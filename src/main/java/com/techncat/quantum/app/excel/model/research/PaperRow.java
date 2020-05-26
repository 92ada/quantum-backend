package com.techncat.quantum.app.excel.model.research;

import com.github.houbb.iexcel.annotation.ExcelField;
import com.techncat.quantum.app.excel.util.FormatUtil;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.model.research.Paper;
import com.techncat.quantum.app.service.utils.JsonLoader;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.stream.Collectors;

@Data
public class PaperRow {
    @ExcelField(headName = "论文名称")
    private String title;
    @ExcelField(headName = "期刊/会议名称")
    private String journal_conference_title;
    @ExcelField(headName = "出版日期")
    private String publication_date;
    @ExcelField(headName = "卷号")
    private String volume_no;
    @ExcelField(headName = "期号或文献号")
    private String document_no;
    @ExcelField(headName = "是否以南科大为第一作者单位或通信作者单位（量子研究院or物理系）")
    private String is_under_sustech;
    @ExcelField(headName = "南科大单位排序")
    private String sustech_institution_rank;
    @ExcelField(headName = "南科大作者工号")
    private String authorSid;
    @ExcelField(headName = "南科大作者姓名")
    private String authorName;
    @ExcelField(headName = "作者排序")
    private String author_rank;
    @ExcelField(headName = "是否国际合作论文")
    private String is_international;
    @ExcelField(headName = "是否自然指数期刊")
    private String is_nature_index;
    @ExcelField(headName = "是否会议论文")
    private String is_conference_paper;
    @ExcelField(headName = "期刊收录类别")
    private String journal_acceptance_type;
    @ExcelField(headName = "JCR分区")
    private String jcr_partition;
    @ExcelField(headName = "影响因子")
    private String impact_factor;
    @ExcelField(headName = "文章致谢")
    private String article_thanks;

    public static PaperRow render(Paper paper) {
        PaperRow row = new PaperRow();
        if (paper.getSustech_people() != null && paper.getSustech_people().size() != 0) {
            row.authorName = paper.getSustech_people().stream().map(People::getName).collect(Collectors.joining(","));
            row.authorSid = paper.getSustech_people().stream().map(People::getSid).collect(Collectors.joining(","));
        }

        row.title = paper.getTitle();
        row.journal_conference_title = paper.getJournal_conference_title();
        row.publication_date = FormatUtil.formatDate(paper.getPublication_date());
        row.volume_no = paper.getVolume_no();
        row.document_no = paper.getDocument_no();
        row.is_under_sustech = FormatUtil.format(paper.getIs_under_sustech());
        row.sustech_institution_rank = FormatUtil.format(paper.getSustech_institution_rank());
        row.author_rank = FormatUtil.format(paper.getAuthor_rank());
        row.is_international = FormatUtil.format(paper.getIs_international());
        row.is_nature_index = FormatUtil.format(paper.getIs_nature_index());
        row.is_conference_paper = FormatUtil.format(paper.getIs_conference_paper());
        row.journal_acceptance_type = paper.getJournal_acceptance_type();
        row.jcr_partition = paper.getJcr_partition();
        row.impact_factor = FormatUtil.format(paper.getImpact_factor());
        row.article_thanks = paper.getArticle_thanks();

        return row;
    }

    public static Paper load(PaperRow row) {
        if (row.title == null || row.title.trim().length() == 0) return null;
        Paper p = new Paper();
        p.setId(null);
        p.setUpdateAt(new Date());
        p.setCreatedAt(new Date());

        p.setSustech_people(RowUtil.loadPeopleListFromSid(row.authorSid));
        p.setAuthorJson(RowUtil.toJson(p.getSustech_people()));
        p.setTitle(row.title);
        p.setJournal_conference_title(row.journal_conference_title);
        p.setPublication_date(FormatUtil.formatDate(row.publication_date));
        p.setVolume_no(row.volume_no);
        p.setDocument_no(row.document_no);
        p.setIs_under_sustech(FormatUtil.toBoolean(row.is_under_sustech));
        p.setSustech_institution_rank(FormatUtil.toInteger(row.sustech_institution_rank));
        p.setAuthor_rank(FormatUtil.toInteger(row.author_rank));
        p.setIs_international(FormatUtil.toBoolean(row.is_international));
        p.setIs_nature_index(FormatUtil.toBoolean(row.is_nature_index));
        p.setIs_conference_paper(FormatUtil.toBoolean(row.is_conference_paper));
        p.setJournal_acceptance_type(row.journal_acceptance_type);
        p.setJcr_partition(row.jcr_partition);
        p.setImpact_factor(FormatUtil.toFloat(row.impact_factor));
        p.setArticle_thanks(row.article_thanks);
        return p;
    }
}
