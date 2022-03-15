package com.pink.freecoffee.entity;

import java.util.ArrayList;
import java.util.List;

public class FollowRelationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FollowRelationExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFollowers_idIsNull() {
            addCriterion("followers_id is null");
            return (Criteria) this;
        }

        public Criteria andFollowers_idIsNotNull() {
            addCriterion("followers_id is not null");
            return (Criteria) this;
        }

        public Criteria andFollowers_idEqualTo(Integer value) {
            addCriterion("followers_id =", value, "followers_id");
            return (Criteria) this;
        }

        public Criteria andFollowers_idNotEqualTo(Integer value) {
            addCriterion("followers_id <>", value, "followers_id");
            return (Criteria) this;
        }

        public Criteria andFollowers_idGreaterThan(Integer value) {
            addCriterion("followers_id >", value, "followers_id");
            return (Criteria) this;
        }

        public Criteria andFollowers_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("followers_id >=", value, "followers_id");
            return (Criteria) this;
        }

        public Criteria andFollowers_idLessThan(Integer value) {
            addCriterion("followers_id <", value, "followers_id");
            return (Criteria) this;
        }

        public Criteria andFollowers_idLessThanOrEqualTo(Integer value) {
            addCriterion("followers_id <=", value, "followers_id");
            return (Criteria) this;
        }

        public Criteria andFollowers_idIn(List<Integer> values) {
            addCriterion("followers_id in", values, "followers_id");
            return (Criteria) this;
        }

        public Criteria andFollowers_idNotIn(List<Integer> values) {
            addCriterion("followers_id not in", values, "followers_id");
            return (Criteria) this;
        }

        public Criteria andFollowers_idBetween(Integer value1, Integer value2) {
            addCriterion("followers_id between", value1, value2, "followers_id");
            return (Criteria) this;
        }

        public Criteria andFollowers_idNotBetween(Integer value1, Integer value2) {
            addCriterion("followers_id not between", value1, value2, "followers_id");
            return (Criteria) this;
        }

        public Criteria andFollowing_idIsNull() {
            addCriterion("following_id is null");
            return (Criteria) this;
        }

        public Criteria andFollowing_idIsNotNull() {
            addCriterion("following_id is not null");
            return (Criteria) this;
        }

        public Criteria andFollowing_idEqualTo(Integer value) {
            addCriterion("following_id =", value, "following_id");
            return (Criteria) this;
        }

        public Criteria andFollowing_idNotEqualTo(Integer value) {
            addCriterion("following_id <>", value, "following_id");
            return (Criteria) this;
        }

        public Criteria andFollowing_idGreaterThan(Integer value) {
            addCriterion("following_id >", value, "following_id");
            return (Criteria) this;
        }

        public Criteria andFollowing_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("following_id >=", value, "following_id");
            return (Criteria) this;
        }

        public Criteria andFollowing_idLessThan(Integer value) {
            addCriterion("following_id <", value, "following_id");
            return (Criteria) this;
        }

        public Criteria andFollowing_idLessThanOrEqualTo(Integer value) {
            addCriterion("following_id <=", value, "following_id");
            return (Criteria) this;
        }

        public Criteria andFollowing_idIn(List<Integer> values) {
            addCriterion("following_id in", values, "following_id");
            return (Criteria) this;
        }

        public Criteria andFollowing_idNotIn(List<Integer> values) {
            addCriterion("following_id not in", values, "following_id");
            return (Criteria) this;
        }

        public Criteria andFollowing_idBetween(Integer value1, Integer value2) {
            addCriterion("following_id between", value1, value2, "following_id");
            return (Criteria) this;
        }

        public Criteria andFollowing_idNotBetween(Integer value1, Integer value2) {
            addCriterion("following_id not between", value1, value2, "following_id");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

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