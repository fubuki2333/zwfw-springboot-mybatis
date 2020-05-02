package gov.shenyang.zwfw.model;

public class Apply {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.id
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.user_id
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.id_card_pic
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    private String idCardPic;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.care_card
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    private String careCard;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.care_card_pic
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    private String careCardPic;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.prescription_pic
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    private String prescriptionPic;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.treatment_date
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    private String treatmentDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.admin_id
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    private Long adminId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.state
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    private String state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.gmt_create
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.invoice_pic
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    private String invoicePic;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.id
     *
     * @return the value of apply.id
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.id
     *
     * @param id the value for apply.id
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.user_id
     *
     * @return the value of apply.user_id
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.user_id
     *
     * @param userId the value for apply.user_id
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.id_card_pic
     *
     * @return the value of apply.id_card_pic
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public String getIdCardPic() {
        return idCardPic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.id_card_pic
     *
     * @param idCardPic the value for apply.id_card_pic
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public void setIdCardPic(String idCardPic) {
        this.idCardPic = idCardPic == null ? null : idCardPic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.care_card
     *
     * @return the value of apply.care_card
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public String getCareCard() {
        return careCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.care_card
     *
     * @param careCard the value for apply.care_card
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public void setCareCard(String careCard) {
        this.careCard = careCard == null ? null : careCard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.care_card_pic
     *
     * @return the value of apply.care_card_pic
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public String getCareCardPic() {
        return careCardPic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.care_card_pic
     *
     * @param careCardPic the value for apply.care_card_pic
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public void setCareCardPic(String careCardPic) {
        this.careCardPic = careCardPic == null ? null : careCardPic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.prescription_pic
     *
     * @return the value of apply.prescription_pic
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public String getPrescriptionPic() {
        return prescriptionPic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.prescription_pic
     *
     * @param prescriptionPic the value for apply.prescription_pic
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public void setPrescriptionPic(String prescriptionPic) {
        this.prescriptionPic = prescriptionPic == null ? null : prescriptionPic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.treatment_date
     *
     * @return the value of apply.treatment_date
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public String getTreatmentDate() {
        return treatmentDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.treatment_date
     *
     * @param treatmentDate the value for apply.treatment_date
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public void setTreatmentDate(String treatmentDate) {
        this.treatmentDate = treatmentDate == null ? null : treatmentDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.admin_id
     *
     * @return the value of apply.admin_id
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public Long getAdminId() {
        return adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.admin_id
     *
     * @param adminId the value for apply.admin_id
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.state
     *
     * @return the value of apply.state
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.state
     *
     * @param state the value for apply.state
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.gmt_create
     *
     * @return the value of apply.gmt_create
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.gmt_create
     *
     * @param gmtCreate the value for apply.gmt_create
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.invoice_pic
     *
     * @return the value of apply.invoice_pic
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public String getInvoicePic() {
        return invoicePic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.invoice_pic
     *
     * @param invoicePic the value for apply.invoice_pic
     *
     * @mbg.generated Sat May 02 11:21:39 CST 2020
     */
    public void setInvoicePic(String invoicePic) {
        this.invoicePic = invoicePic == null ? null : invoicePic.trim();
    }
}