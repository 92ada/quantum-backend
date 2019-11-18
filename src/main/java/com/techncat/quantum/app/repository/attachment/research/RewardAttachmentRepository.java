package com.techncat.quantum.app.repository.attachment.research;

import com.techncat.quantum.app.model.attachment.research.RewardAttachment;
import com.techncat.quantum.app.model.research.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RewardAttachmentRepository extends JpaRepository<RewardAttachment, Long> {
    List<RewardAttachment> findAllByReward(Reward reward);
}
