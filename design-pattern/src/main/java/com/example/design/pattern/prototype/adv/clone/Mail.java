package com.example.design.pattern.prototype.adv.clone;

import com.example.design.pattern.prototype.adv.AdvTemplate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mail implements Cloneable {

    private String receiver;
    private String subject;
    private String appellation;
    private String context;
    private String tail;


    public Mail(AdvTemplate advTemplate) {
        this.context = advTemplate.getAdvContext();
        this.subject = advTemplate.getAdvSubject();
    }

    @Override
    protected Mail clone() throws CloneNotSupportedException {
        Mail mail = null;
        try {
            mail = (Mail) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return mail;
    }
}
