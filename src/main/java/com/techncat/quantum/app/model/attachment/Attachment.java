package com.techncat.quantum.app.model.attachment;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "attachments")
public class Attachment {
    enum TYPE {
        doc, xls, ppt, docx, xlsx, pptx, pdf, txt, zip, rar, mp3, mp4, jpg, png, jpeg
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String url;
    @Enumerated
    private TYPE type;
    private Date createdAt = new Date(); // default

    @Transient
    private Long recordId;
}
