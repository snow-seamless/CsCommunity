package com.community.model;

import java.util.ArrayList;
import java.util.List;

public class StarExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table star_record
     *
<<<<<<< HEAD
     * @mbg.generated Fri May 13 21:31:01 GMT+08:00 2022
=======
     * @mbg.generated Fri May 13 21:29:48 CST 2022
>>>>>>> 867e11aaffb7bc5c524c4cf1c8fc98ddf58a8f1e
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table star_record
     *
<<<<<<< HEAD
     * @mbg.generated Fri May 13 21:31:01 GMT+08:00 2022
=======
     * @mbg.generated Fri May 13 21:29:48 CST 2022
>>>>>>> 867e11aaffb7bc5c524c4cf1c8fc98ddf58a8f1e
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table star_record
     *
<<<<<<< HEAD
     * @mbg.generated Fri May 13 21:31:01 GMT+08:00 2022
=======
     * @mbg.generated Fri May 13 21:29:48 CST 2022
>>>>>>> 867e11aaffb7bc5c524c4cf1c8fc98ddf58a8f1e
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star_record
     *
<<<<<<< HEAD
     * @mbg.generated Fri May 13 21:31:01 GMT+08:00 2022
=======
     * @mbg.generated Fri May 13 21:29:48 CST 2022
>>>>>>> 867e11aaffb7bc5c524c4cf1c8fc98ddf58a8f1e
     */
    public StarExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star_record
     *
<<<<<<< HEAD
     * @mbg.generated Fri May 13 21:31:01 GMT+08:00 2022
=======
     * @mbg.generated Fri May 13 21:29:48 CST 2022
>>>>>>> 867e11aaffb7bc5c524c4cf1c8fc98ddf58a8f1e
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star_record
     *
<<<<<<< HEAD
     * @mbg.generated Fri May 13 21:31:01 GMT+08:00 2022
=======
     * @mbg.generated Fri May 13 21:29:48 CST 2022
>>>>>>> 867e11aaffb7bc5c524c4cf1c8fc98ddf58a8f1e
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star_record
     *
<<<<<<< HEAD
     * @mbg.generated Fri May 13 21:31:01 GMT+08:00 2022
=======
     * @mbg.generated Fri May 13 21:29:48 CST 2022
>>>>>>> 867e11aaffb7bc5c524c4cf1c8fc98ddf58a8f1e
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star_record
     *
<<<<<<< HEAD
     * @mbg.generated Fri May 13 21:31:01 GMT+08:00 2022
=======
     * @mbg.generated Fri May 13 21:29:48 CST 2022
>>>>>>> 867e11aaffb7bc5c524c4cf1c8fc98ddf58a8f1e
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star_record
     *
<<<<<<< HEAD
     * @mbg.generated Fri May 13 21:31:01 GMT+08:00 2022
=======
     * @mbg.generated Fri May 13 21:29:48 CST 2022
>>>>>>> 867e11aaffb7bc5c524c4cf1c8fc98ddf58a8f1e
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star_record
     *
<<<<<<< HEAD
     * @mbg.generated Fri May 13 21:31:01 GMT+08:00 2022
=======
     * @mbg.generated Fri May 13 21:29:48 CST 2022
>>>>>>> 867e11aaffb7bc5c524c4cf1c8fc98ddf58a8f1e
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star_record
     *
<<<<<<< HEAD
     * @mbg.generated Fri May 13 21:31:01 GMT+08:00 2022
=======
     * @mbg.generated Fri May 13 21:29:48 CST 2022
>>>>>>> 867e11aaffb7bc5c524c4cf1c8fc98ddf58a8f1e
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star_record
     *
<<<<<<< HEAD
     * @mbg.generated Fri May 13 21:31:01 GMT+08:00 2022
=======
     * @mbg.generated Fri May 13 21:29:48 CST 2022
>>>>>>> 867e11aaffb7bc5c524c4cf1c8fc98ddf58a8f1e
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star_record
     *
<<<<<<< HEAD
     * @mbg.generated Fri May 13 21:31:01 GMT+08:00 2022
=======
     * @mbg.generated Fri May 13 21:29:48 CST 2022
>>>>>>> 867e11aaffb7bc5c524c4cf1c8fc98ddf58a8f1e
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star_record
     *
<<<<<<< HEAD
     * @mbg.generated Fri May 13 21:31:01 GMT+08:00 2022
=======
     * @mbg.generated Fri May 13 21:29:48 CST 2022
>>>>>>> 867e11aaffb7bc5c524c4cf1c8fc98ddf58a8f1e
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table star_record
     *
<<<<<<< HEAD
     * @mbg.generated Fri May 13 21:31:01 GMT+08:00 2022
=======
     * @mbg.generated Fri May 13 21:29:48 CST 2022
>>>>>>> 867e11aaffb7bc5c524c4cf1c8fc98ddf58a8f1e
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTargetIdIsNull() {
            addCriterion("target_id is null");
            return (Criteria) this;
        }

        public Criteria andTargetIdIsNotNull() {
            addCriterion("target_id is not null");
            return (Criteria) this;
        }

        public Criteria andTargetIdEqualTo(Long value) {
            addCriterion("target_id =", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotEqualTo(Long value) {
            addCriterion("target_id <>", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdGreaterThan(Long value) {
            addCriterion("target_id >", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdGreaterThanOrEqualTo(Long value) {
            addCriterion("target_id >=", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLessThan(Long value) {
            addCriterion("target_id <", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLessThanOrEqualTo(Long value) {
            addCriterion("target_id <=", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdIn(List<Long> values) {
            addCriterion("target_id in", values, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotIn(List<Long> values) {
            addCriterion("target_id not in", values, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdBetween(Long value1, Long value2) {
            addCriterion("target_id between", value1, value2, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotBetween(Long value1, Long value2) {
            addCriterion("target_id not between", value1, value2, "targetId");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Long value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Long value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Long value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Long value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Long value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Long value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Long> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Long> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Long value1, Long value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Long value1, Long value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Long value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Long value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Long value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Long value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Long value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Long value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Long> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Long> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Long value1, Long value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Long value1, Long value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andStarCreatorIsNull() {
            addCriterion("star_creator is null");
            return (Criteria) this;
        }

        public Criteria andStarCreatorIsNotNull() {
            addCriterion("star_creator is not null");
            return (Criteria) this;
        }

        public Criteria andStarCreatorEqualTo(String value) {
            addCriterion("star_creator =", value, "starCreator");
            return (Criteria) this;
        }

        public Criteria andStarCreatorNotEqualTo(String value) {
            addCriterion("star_creator <>", value, "starCreator");
            return (Criteria) this;
        }

        public Criteria andStarCreatorGreaterThan(String value) {
            addCriterion("star_creator >", value, "starCreator");
            return (Criteria) this;
        }

        public Criteria andStarCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("star_creator >=", value, "starCreator");
            return (Criteria) this;
        }

        public Criteria andStarCreatorLessThan(String value) {
            addCriterion("star_creator <", value, "starCreator");
            return (Criteria) this;
        }

        public Criteria andStarCreatorLessThanOrEqualTo(String value) {
            addCriterion("star_creator <=", value, "starCreator");
            return (Criteria) this;
        }

        public Criteria andStarCreatorLike(String value) {
            addCriterion("star_creator like", value, "starCreator");
            return (Criteria) this;
        }

        public Criteria andStarCreatorNotLike(String value) {
            addCriterion("star_creator not like", value, "starCreator");
            return (Criteria) this;
        }

        public Criteria andStarCreatorIn(List<String> values) {
            addCriterion("star_creator in", values, "starCreator");
            return (Criteria) this;
        }

        public Criteria andStarCreatorNotIn(List<String> values) {
            addCriterion("star_creator not in", values, "starCreator");
            return (Criteria) this;
        }

        public Criteria andStarCreatorBetween(String value1, String value2) {
            addCriterion("star_creator between", value1, value2, "starCreator");
            return (Criteria) this;
        }

        public Criteria andStarCreatorNotBetween(String value1, String value2) {
            addCriterion("star_creator not between", value1, value2, "starCreator");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table star_record
     *
<<<<<<< HEAD
     * @mbg.generated do_not_delete_during_merge Fri May 13 21:31:01 GMT+08:00 2022
=======
     * @mbg.generated do_not_delete_during_merge Fri May 13 21:29:48 CST 2022
>>>>>>> 867e11aaffb7bc5c524c4cf1c8fc98ddf58a8f1e
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table star_record
     *
<<<<<<< HEAD
     * @mbg.generated Fri May 13 21:31:01 GMT+08:00 2022
=======
     * @mbg.generated Fri May 13 21:29:48 CST 2022
>>>>>>> 867e11aaffb7bc5c524c4cf1c8fc98ddf58a8f1e
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}