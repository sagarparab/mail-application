package com.java.mail.javasendmailapplication.model;


public class EmailDTO {
    
    /** The to. */
    private String to;
    
    /** The from. */
    private String from;
    
    /** The cc. */
    private String cc;
    
    /** The bcc. */
    private String bcc;
    
    /** The body. */
    private String body;
    
    /** The yono userid. */
    private String yonoUserid;
    
    /** The subject. */
    private String subject;
    
    /** The is HTML content. */
    private boolean isHTMLContent;
    
    /**
     * Gets the to.
     *
     * @return the to
     */
    public String getTo() {
        return to;
    }
    
    /**
     * Sets the to.
     *
     * @param to the new to
     */
    public void setTo(String to) {
        this.to = to;
    }
    
    /**
     * Gets the from.
     *
     * @return the from
     */
    public String getFrom() {
        return from;
    }
    
    /**
     * Sets the from.
     *
     * @param from the new from
     */
    public void setFrom(String from) {
        this.from = from;
    }
    
    /**
     * Gets the cc.
     *
     * @return the cc
     */
    public String getCc() {
        return cc;
    }
    
    /**
     * Sets the cc.
     *
     * @param cc the new cc
     */
    public void setCc(String cc) {
        this.cc = cc;
    }
    
    /**
     * Gets the bcc.
     *
     * @return the bcc
     */
    public String getBcc() {
        return bcc;
    }
    
    /**
     * Sets the bcc.
     *
     * @param bcc the new bcc
     */
    public void setBcc(String bcc) {
        this.bcc = bcc;
    }
    
    /**
     * Gets the body.
     *
     * @return the body
     */
    public String getBody() {
        return body;
    }
    
    /**
     * Sets the body.
     *
     * @param body the new body
     */
    public void setBody(String body) {
        this.body = body;
    }
    
    /**
     * Gets the yono userid.
     *
     * @return the yono userid
     */
    public String getYonoUserid() {
        return yonoUserid;
    }
    
    /**
     * Sets the yono userid.
     *
     * @param yonoUserid the new yono userid
     */
    public void setYonoUserid(String yonoUserid) {
        this.yonoUserid = yonoUserid;
    }
    
    /**
     * Gets the subject.
     *
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }
    
    /**
     * Sets the subject.
     *
     * @param subject the new subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    /**
     * Checks if is HTML content.
     *
     * @return true, if is HTML content
     */
    public boolean isHTMLContent() {
        return isHTMLContent;
    }
    
    /**
     * Sets the HTML content.
     *
     * @param isHTMLContent the new HTML content
     */
    public void setHTMLContent(boolean isHTMLContent) {
        this.isHTMLContent = isHTMLContent;
    }
}
