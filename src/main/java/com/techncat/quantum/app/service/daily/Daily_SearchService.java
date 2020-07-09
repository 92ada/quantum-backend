package com.techncat.quantum.app.service.daily;

import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.model.daily.Hosting;
import com.techncat.quantum.app.model.daily.Report;
import com.techncat.quantum.app.model.daily.Travel;
import com.techncat.quantum.app.model.daily.Visit;
import com.techncat.quantum.app.repository.daily.DailyHostingRepository;
import com.techncat.quantum.app.repository.daily.DailyReportRepository;
import com.techncat.quantum.app.repository.daily.DailyTravelRepository;
import com.techncat.quantum.app.repository.daily.DailyVisitRepository;
import com.techncat.quantum.app.service.people.LabRunner;
import com.techncat.quantum.app.service.people.People_SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static com.techncat.quantum.app.common.auth.AuthUtil.isRoot;

@Service
public class Daily_SearchService {
    @Resource
    private DailyHostingRepository hostingRepository;
    @Resource
    private DailyReportRepository reportRepository;
    @Resource
    private DailyTravelRepository travelRepository;
    @Resource
    private DailyVisitRepository visitRepository;

    public Page<Hosting> searchHosting(String word, Date start, Date end, PageRequest pageRequest) {
        String wordLike = "%" + word + "%";
        if (start == null || end == null) return hostingRepository.findAllByTitleLike(wordLike, pageRequest);
        return hostingRepository.findAllByTitleLikeAndTimeBetween(wordLike, start, end, pageRequest);
    }

    public Page<Report> searchReport(String word, Date start, Date end, PageRequest pageRequest) {
        String wordLike = "%" + word + "%";
        if (start == null || end == null) return avoidRef(reportRepository.findAllByTitleLike(wordLike, pageRequest));
        return avoidRef(reportRepository.findAllByTitleLikeAndTimeBetween(wordLike, start, end, pageRequest));
    }

    public Page<Travel> searchTravel(String word, Date start, Date end, PageRequest pageRequest) {
        String wordLike = "%" + word + "%";
        if (start == null || end == null) return avoidRef(travelRepository.findAllByTraveler_NameLike(wordLike, pageRequest));
        return avoidRef(travelRepository.findAllByTraveler_NameLikeAndStartDateBetween(wordLike, start, end, pageRequest));
    }

    public Page<Visit> searchVisit(String word, Date start, Date end, PageRequest pageRequest) {
        String wordLike = "%" + word + "%";
        if (start == null || end == null) return avoidRef(visitRepository.findAllByNameLike(wordLike, pageRequest));
        return avoidRef(visitRepository.findAllByNameLikeAndTimeBetween(wordLike, start, end, pageRequest));
    }

    private <T> Page<T> avoidRef(Page<T> source) {
        return source.map(record -> {
            if (record instanceof Travel) {
                ((Travel) record).setTraveler(People_SearchService.avoidRef(((Travel) record).getTraveler()));
                return record;
            }
            if (record instanceof Visit) {
                ((Visit) record).setReceptionist(People_SearchService.avoidRef(((Visit) record).getReceptionist()));
                return record;
            }
            if (record instanceof Report) {
                ((Report) record).setInviter(People_SearchService.avoidRef(((Report) record).getInviter()));
                return record;
            }
            return record;
        });
    }
}
