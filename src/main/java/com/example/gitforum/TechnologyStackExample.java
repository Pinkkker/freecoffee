package com.example.gitforum;

import java.util.ArrayList;
import java.util.List;

public class TechnologyStackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TechnologyStackExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andLanguage1IsNull() {
            addCriterion("language1 is null");
            return (Criteria) this;
        }

        public Criteria andLanguage1IsNotNull() {
            addCriterion("language1 is not null");
            return (Criteria) this;
        }

        public Criteria andLanguage1EqualTo(String value) {
            addCriterion("language1 =", value, "language1");
            return (Criteria) this;
        }

        public Criteria andLanguage1NotEqualTo(String value) {
            addCriterion("language1 <>", value, "language1");
            return (Criteria) this;
        }

        public Criteria andLanguage1GreaterThan(String value) {
            addCriterion("language1 >", value, "language1");
            return (Criteria) this;
        }

        public Criteria andLanguage1GreaterThanOrEqualTo(String value) {
            addCriterion("language1 >=", value, "language1");
            return (Criteria) this;
        }

        public Criteria andLanguage1LessThan(String value) {
            addCriterion("language1 <", value, "language1");
            return (Criteria) this;
        }

        public Criteria andLanguage1LessThanOrEqualTo(String value) {
            addCriterion("language1 <=", value, "language1");
            return (Criteria) this;
        }

        public Criteria andLanguage1Like(String value) {
            addCriterion("language1 like", value, "language1");
            return (Criteria) this;
        }

        public Criteria andLanguage1NotLike(String value) {
            addCriterion("language1 not like", value, "language1");
            return (Criteria) this;
        }

        public Criteria andLanguage1In(List<String> values) {
            addCriterion("language1 in", values, "language1");
            return (Criteria) this;
        }

        public Criteria andLanguage1NotIn(List<String> values) {
            addCriterion("language1 not in", values, "language1");
            return (Criteria) this;
        }

        public Criteria andLanguage1Between(String value1, String value2) {
            addCriterion("language1 between", value1, value2, "language1");
            return (Criteria) this;
        }

        public Criteria andLanguage1NotBetween(String value1, String value2) {
            addCriterion("language1 not between", value1, value2, "language1");
            return (Criteria) this;
        }

        public Criteria andLanguage2IsNull() {
            addCriterion("language2 is null");
            return (Criteria) this;
        }

        public Criteria andLanguage2IsNotNull() {
            addCriterion("language2 is not null");
            return (Criteria) this;
        }

        public Criteria andLanguage2EqualTo(String value) {
            addCriterion("language2 =", value, "language2");
            return (Criteria) this;
        }

        public Criteria andLanguage2NotEqualTo(String value) {
            addCriterion("language2 <>", value, "language2");
            return (Criteria) this;
        }

        public Criteria andLanguage2GreaterThan(String value) {
            addCriterion("language2 >", value, "language2");
            return (Criteria) this;
        }

        public Criteria andLanguage2GreaterThanOrEqualTo(String value) {
            addCriterion("language2 >=", value, "language2");
            return (Criteria) this;
        }

        public Criteria andLanguage2LessThan(String value) {
            addCriterion("language2 <", value, "language2");
            return (Criteria) this;
        }

        public Criteria andLanguage2LessThanOrEqualTo(String value) {
            addCriterion("language2 <=", value, "language2");
            return (Criteria) this;
        }

        public Criteria andLanguage2Like(String value) {
            addCriterion("language2 like", value, "language2");
            return (Criteria) this;
        }

        public Criteria andLanguage2NotLike(String value) {
            addCriterion("language2 not like", value, "language2");
            return (Criteria) this;
        }

        public Criteria andLanguage2In(List<String> values) {
            addCriterion("language2 in", values, "language2");
            return (Criteria) this;
        }

        public Criteria andLanguage2NotIn(List<String> values) {
            addCriterion("language2 not in", values, "language2");
            return (Criteria) this;
        }

        public Criteria andLanguage2Between(String value1, String value2) {
            addCriterion("language2 between", value1, value2, "language2");
            return (Criteria) this;
        }

        public Criteria andLanguage2NotBetween(String value1, String value2) {
            addCriterion("language2 not between", value1, value2, "language2");
            return (Criteria) this;
        }

        public Criteria andLanguage3IsNull() {
            addCriterion("language3 is null");
            return (Criteria) this;
        }

        public Criteria andLanguage3IsNotNull() {
            addCriterion("language3 is not null");
            return (Criteria) this;
        }

        public Criteria andLanguage3EqualTo(String value) {
            addCriterion("language3 =", value, "language3");
            return (Criteria) this;
        }

        public Criteria andLanguage3NotEqualTo(String value) {
            addCriterion("language3 <>", value, "language3");
            return (Criteria) this;
        }

        public Criteria andLanguage3GreaterThan(String value) {
            addCriterion("language3 >", value, "language3");
            return (Criteria) this;
        }

        public Criteria andLanguage3GreaterThanOrEqualTo(String value) {
            addCriterion("language3 >=", value, "language3");
            return (Criteria) this;
        }

        public Criteria andLanguage3LessThan(String value) {
            addCriterion("language3 <", value, "language3");
            return (Criteria) this;
        }

        public Criteria andLanguage3LessThanOrEqualTo(String value) {
            addCriterion("language3 <=", value, "language3");
            return (Criteria) this;
        }

        public Criteria andLanguage3Like(String value) {
            addCriterion("language3 like", value, "language3");
            return (Criteria) this;
        }

        public Criteria andLanguage3NotLike(String value) {
            addCriterion("language3 not like", value, "language3");
            return (Criteria) this;
        }

        public Criteria andLanguage3In(List<String> values) {
            addCriterion("language3 in", values, "language3");
            return (Criteria) this;
        }

        public Criteria andLanguage3NotIn(List<String> values) {
            addCriterion("language3 not in", values, "language3");
            return (Criteria) this;
        }

        public Criteria andLanguage3Between(String value1, String value2) {
            addCriterion("language3 between", value1, value2, "language3");
            return (Criteria) this;
        }

        public Criteria andLanguage3NotBetween(String value1, String value2) {
            addCriterion("language3 not between", value1, value2, "language3");
            return (Criteria) this;
        }

        public Criteria andLanguage4IsNull() {
            addCriterion("language4 is null");
            return (Criteria) this;
        }

        public Criteria andLanguage4IsNotNull() {
            addCriterion("language4 is not null");
            return (Criteria) this;
        }

        public Criteria andLanguage4EqualTo(String value) {
            addCriterion("language4 =", value, "language4");
            return (Criteria) this;
        }

        public Criteria andLanguage4NotEqualTo(String value) {
            addCriterion("language4 <>", value, "language4");
            return (Criteria) this;
        }

        public Criteria andLanguage4GreaterThan(String value) {
            addCriterion("language4 >", value, "language4");
            return (Criteria) this;
        }

        public Criteria andLanguage4GreaterThanOrEqualTo(String value) {
            addCriterion("language4 >=", value, "language4");
            return (Criteria) this;
        }

        public Criteria andLanguage4LessThan(String value) {
            addCriterion("language4 <", value, "language4");
            return (Criteria) this;
        }

        public Criteria andLanguage4LessThanOrEqualTo(String value) {
            addCriterion("language4 <=", value, "language4");
            return (Criteria) this;
        }

        public Criteria andLanguage4Like(String value) {
            addCriterion("language4 like", value, "language4");
            return (Criteria) this;
        }

        public Criteria andLanguage4NotLike(String value) {
            addCriterion("language4 not like", value, "language4");
            return (Criteria) this;
        }

        public Criteria andLanguage4In(List<String> values) {
            addCriterion("language4 in", values, "language4");
            return (Criteria) this;
        }

        public Criteria andLanguage4NotIn(List<String> values) {
            addCriterion("language4 not in", values, "language4");
            return (Criteria) this;
        }

        public Criteria andLanguage4Between(String value1, String value2) {
            addCriterion("language4 between", value1, value2, "language4");
            return (Criteria) this;
        }

        public Criteria andLanguage4NotBetween(String value1, String value2) {
            addCriterion("language4 not between", value1, value2, "language4");
            return (Criteria) this;
        }

        public Criteria andLanguage5IsNull() {
            addCriterion("language5 is null");
            return (Criteria) this;
        }

        public Criteria andLanguage5IsNotNull() {
            addCriterion("language5 is not null");
            return (Criteria) this;
        }

        public Criteria andLanguage5EqualTo(String value) {
            addCriterion("language5 =", value, "language5");
            return (Criteria) this;
        }

        public Criteria andLanguage5NotEqualTo(String value) {
            addCriterion("language5 <>", value, "language5");
            return (Criteria) this;
        }

        public Criteria andLanguage5GreaterThan(String value) {
            addCriterion("language5 >", value, "language5");
            return (Criteria) this;
        }

        public Criteria andLanguage5GreaterThanOrEqualTo(String value) {
            addCriterion("language5 >=", value, "language5");
            return (Criteria) this;
        }

        public Criteria andLanguage5LessThan(String value) {
            addCriterion("language5 <", value, "language5");
            return (Criteria) this;
        }

        public Criteria andLanguage5LessThanOrEqualTo(String value) {
            addCriterion("language5 <=", value, "language5");
            return (Criteria) this;
        }

        public Criteria andLanguage5Like(String value) {
            addCriterion("language5 like", value, "language5");
            return (Criteria) this;
        }

        public Criteria andLanguage5NotLike(String value) {
            addCriterion("language5 not like", value, "language5");
            return (Criteria) this;
        }

        public Criteria andLanguage5In(List<String> values) {
            addCriterion("language5 in", values, "language5");
            return (Criteria) this;
        }

        public Criteria andLanguage5NotIn(List<String> values) {
            addCriterion("language5 not in", values, "language5");
            return (Criteria) this;
        }

        public Criteria andLanguage5Between(String value1, String value2) {
            addCriterion("language5 between", value1, value2, "language5");
            return (Criteria) this;
        }

        public Criteria andLanguage5NotBetween(String value1, String value2) {
            addCriterion("language5 not between", value1, value2, "language5");
            return (Criteria) this;
        }

        public Criteria andLanguage6IsNull() {
            addCriterion("language6 is null");
            return (Criteria) this;
        }

        public Criteria andLanguage6IsNotNull() {
            addCriterion("language6 is not null");
            return (Criteria) this;
        }

        public Criteria andLanguage6EqualTo(String value) {
            addCriterion("language6 =", value, "language6");
            return (Criteria) this;
        }

        public Criteria andLanguage6NotEqualTo(String value) {
            addCriterion("language6 <>", value, "language6");
            return (Criteria) this;
        }

        public Criteria andLanguage6GreaterThan(String value) {
            addCriterion("language6 >", value, "language6");
            return (Criteria) this;
        }

        public Criteria andLanguage6GreaterThanOrEqualTo(String value) {
            addCriterion("language6 >=", value, "language6");
            return (Criteria) this;
        }

        public Criteria andLanguage6LessThan(String value) {
            addCriterion("language6 <", value, "language6");
            return (Criteria) this;
        }

        public Criteria andLanguage6LessThanOrEqualTo(String value) {
            addCriterion("language6 <=", value, "language6");
            return (Criteria) this;
        }

        public Criteria andLanguage6Like(String value) {
            addCriterion("language6 like", value, "language6");
            return (Criteria) this;
        }

        public Criteria andLanguage6NotLike(String value) {
            addCriterion("language6 not like", value, "language6");
            return (Criteria) this;
        }

        public Criteria andLanguage6In(List<String> values) {
            addCriterion("language6 in", values, "language6");
            return (Criteria) this;
        }

        public Criteria andLanguage6NotIn(List<String> values) {
            addCriterion("language6 not in", values, "language6");
            return (Criteria) this;
        }

        public Criteria andLanguage6Between(String value1, String value2) {
            addCriterion("language6 between", value1, value2, "language6");
            return (Criteria) this;
        }

        public Criteria andLanguage6NotBetween(String value1, String value2) {
            addCriterion("language6 not between", value1, value2, "language6");
            return (Criteria) this;
        }

        public Criteria andLanguage7IsNull() {
            addCriterion("language7 is null");
            return (Criteria) this;
        }

        public Criteria andLanguage7IsNotNull() {
            addCriterion("language7 is not null");
            return (Criteria) this;
        }

        public Criteria andLanguage7EqualTo(String value) {
            addCriterion("language7 =", value, "language7");
            return (Criteria) this;
        }

        public Criteria andLanguage7NotEqualTo(String value) {
            addCriterion("language7 <>", value, "language7");
            return (Criteria) this;
        }

        public Criteria andLanguage7GreaterThan(String value) {
            addCriterion("language7 >", value, "language7");
            return (Criteria) this;
        }

        public Criteria andLanguage7GreaterThanOrEqualTo(String value) {
            addCriterion("language7 >=", value, "language7");
            return (Criteria) this;
        }

        public Criteria andLanguage7LessThan(String value) {
            addCriterion("language7 <", value, "language7");
            return (Criteria) this;
        }

        public Criteria andLanguage7LessThanOrEqualTo(String value) {
            addCriterion("language7 <=", value, "language7");
            return (Criteria) this;
        }

        public Criteria andLanguage7Like(String value) {
            addCriterion("language7 like", value, "language7");
            return (Criteria) this;
        }

        public Criteria andLanguage7NotLike(String value) {
            addCriterion("language7 not like", value, "language7");
            return (Criteria) this;
        }

        public Criteria andLanguage7In(List<String> values) {
            addCriterion("language7 in", values, "language7");
            return (Criteria) this;
        }

        public Criteria andLanguage7NotIn(List<String> values) {
            addCriterion("language7 not in", values, "language7");
            return (Criteria) this;
        }

        public Criteria andLanguage7Between(String value1, String value2) {
            addCriterion("language7 between", value1, value2, "language7");
            return (Criteria) this;
        }

        public Criteria andLanguage7NotBetween(String value1, String value2) {
            addCriterion("language7 not between", value1, value2, "language7");
            return (Criteria) this;
        }

        public Criteria andLanguage8IsNull() {
            addCriterion("language8 is null");
            return (Criteria) this;
        }

        public Criteria andLanguage8IsNotNull() {
            addCriterion("language8 is not null");
            return (Criteria) this;
        }

        public Criteria andLanguage8EqualTo(String value) {
            addCriterion("language8 =", value, "language8");
            return (Criteria) this;
        }

        public Criteria andLanguage8NotEqualTo(String value) {
            addCriterion("language8 <>", value, "language8");
            return (Criteria) this;
        }

        public Criteria andLanguage8GreaterThan(String value) {
            addCriterion("language8 >", value, "language8");
            return (Criteria) this;
        }

        public Criteria andLanguage8GreaterThanOrEqualTo(String value) {
            addCriterion("language8 >=", value, "language8");
            return (Criteria) this;
        }

        public Criteria andLanguage8LessThan(String value) {
            addCriterion("language8 <", value, "language8");
            return (Criteria) this;
        }

        public Criteria andLanguage8LessThanOrEqualTo(String value) {
            addCriterion("language8 <=", value, "language8");
            return (Criteria) this;
        }

        public Criteria andLanguage8Like(String value) {
            addCriterion("language8 like", value, "language8");
            return (Criteria) this;
        }

        public Criteria andLanguage8NotLike(String value) {
            addCriterion("language8 not like", value, "language8");
            return (Criteria) this;
        }

        public Criteria andLanguage8In(List<String> values) {
            addCriterion("language8 in", values, "language8");
            return (Criteria) this;
        }

        public Criteria andLanguage8NotIn(List<String> values) {
            addCriterion("language8 not in", values, "language8");
            return (Criteria) this;
        }

        public Criteria andLanguage8Between(String value1, String value2) {
            addCriterion("language8 between", value1, value2, "language8");
            return (Criteria) this;
        }

        public Criteria andLanguage8NotBetween(String value1, String value2) {
            addCriterion("language8 not between", value1, value2, "language8");
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