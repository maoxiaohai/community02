package com.springboot.community02.model;

public class Comment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENT.ID
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENT.PARENT_ID
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    private Long parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENT.TYPE
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENT.COMMENTATOR
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    private Integer commentator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENT.GMT_CREATE
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENT.GMT_MODIFIED
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    private Long gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENT.LIKE_COUNT
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    private Long likeCount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENT.ID
     *
     * @return the value of COMMENT.ID
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENT.ID
     *
     * @param id the value for COMMENT.ID
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENT.PARENT_ID
     *
     * @return the value of COMMENT.PARENT_ID
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENT.PARENT_ID
     *
     * @param parentId the value for COMMENT.PARENT_ID
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENT.TYPE
     *
     * @return the value of COMMENT.TYPE
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENT.TYPE
     *
     * @param type the value for COMMENT.TYPE
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENT.COMMENTATOR
     *
     * @return the value of COMMENT.COMMENTATOR
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    public Integer getCommentator() {
        return commentator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENT.COMMENTATOR
     *
     * @param commentator the value for COMMENT.COMMENTATOR
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    public void setCommentator(Integer commentator) {
        this.commentator = commentator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENT.GMT_CREATE
     *
     * @return the value of COMMENT.GMT_CREATE
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENT.GMT_CREATE
     *
     * @param gmtCreate the value for COMMENT.GMT_CREATE
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENT.GMT_MODIFIED
     *
     * @return the value of COMMENT.GMT_MODIFIED
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENT.GMT_MODIFIED
     *
     * @param gmtModified the value for COMMENT.GMT_MODIFIED
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENT.LIKE_COUNT
     *
     * @return the value of COMMENT.LIKE_COUNT
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    public Long getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENT.LIKE_COUNT
     *
     * @param likeCount the value for COMMENT.LIKE_COUNT
     *
     * @mbg.generated Wed Apr 01 23:33:25 CST 2020
     */
    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }
}