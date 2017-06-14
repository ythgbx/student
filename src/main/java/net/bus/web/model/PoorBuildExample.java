package net.bus.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PoorBuildExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PoorBuildExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andIdcardIsNull() {
            addCriterion("idcard is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNotNull() {
            addCriterion("idcard is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardEqualTo(String value) {
            addCriterion("idcard =", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotEqualTo(String value) {
            addCriterion("idcard <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThan(String value) {
            addCriterion("idcard >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("idcard >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThan(String value) {
            addCriterion("idcard <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThanOrEqualTo(String value) {
            addCriterion("idcard <=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLike(String value) {
            addCriterion("idcard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLike(String value) {
            addCriterion("idcard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardIn(List<String> values) {
            addCriterion("idcard in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotIn(List<String> values) {
            addCriterion("idcard not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("idcard between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("idcard not between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andInsuranceIsNull() {
            addCriterion("Insurance is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceIsNotNull() {
            addCriterion("Insurance is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceEqualTo(String value) {
            addCriterion("Insurance =", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceNotEqualTo(String value) {
            addCriterion("Insurance <>", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceGreaterThan(String value) {
            addCriterion("Insurance >", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceGreaterThanOrEqualTo(String value) {
            addCriterion("Insurance >=", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceLessThan(String value) {
            addCriterion("Insurance <", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceLessThanOrEqualTo(String value) {
            addCriterion("Insurance <=", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceLike(String value) {
            addCriterion("Insurance like", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceNotLike(String value) {
            addCriterion("Insurance not like", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceIn(List<String> values) {
            addCriterion("Insurance in", values, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceNotIn(List<String> values) {
            addCriterion("Insurance not in", values, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceBetween(String value1, String value2) {
            addCriterion("Insurance between", value1, value2, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceNotBetween(String value1, String value2) {
            addCriterion("Insurance not between", value1, value2, "insurance");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andEconomicsourcesIsNull() {
            addCriterion("economicSources is null");
            return (Criteria) this;
        }

        public Criteria andEconomicsourcesIsNotNull() {
            addCriterion("economicSources is not null");
            return (Criteria) this;
        }

        public Criteria andEconomicsourcesEqualTo(String value) {
            addCriterion("economicSources =", value, "economicsources");
            return (Criteria) this;
        }

        public Criteria andEconomicsourcesNotEqualTo(String value) {
            addCriterion("economicSources <>", value, "economicsources");
            return (Criteria) this;
        }

        public Criteria andEconomicsourcesGreaterThan(String value) {
            addCriterion("economicSources >", value, "economicsources");
            return (Criteria) this;
        }

        public Criteria andEconomicsourcesGreaterThanOrEqualTo(String value) {
            addCriterion("economicSources >=", value, "economicsources");
            return (Criteria) this;
        }

        public Criteria andEconomicsourcesLessThan(String value) {
            addCriterion("economicSources <", value, "economicsources");
            return (Criteria) this;
        }

        public Criteria andEconomicsourcesLessThanOrEqualTo(String value) {
            addCriterion("economicSources <=", value, "economicsources");
            return (Criteria) this;
        }

        public Criteria andEconomicsourcesLike(String value) {
            addCriterion("economicSources like", value, "economicsources");
            return (Criteria) this;
        }

        public Criteria andEconomicsourcesNotLike(String value) {
            addCriterion("economicSources not like", value, "economicsources");
            return (Criteria) this;
        }

        public Criteria andEconomicsourcesIn(List<String> values) {
            addCriterion("economicSources in", values, "economicsources");
            return (Criteria) this;
        }

        public Criteria andEconomicsourcesNotIn(List<String> values) {
            addCriterion("economicSources not in", values, "economicsources");
            return (Criteria) this;
        }

        public Criteria andEconomicsourcesBetween(String value1, String value2) {
            addCriterion("economicSources between", value1, value2, "economicsources");
            return (Criteria) this;
        }

        public Criteria andEconomicsourcesNotBetween(String value1, String value2) {
            addCriterion("economicSources not between", value1, value2, "economicsources");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeIsNull() {
            addCriterion("familyIncome is null");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeIsNotNull() {
            addCriterion("familyIncome is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeEqualTo(Integer value) {
            addCriterion("familyIncome =", value, "familyincome");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeNotEqualTo(Integer value) {
            addCriterion("familyIncome <>", value, "familyincome");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeGreaterThan(Integer value) {
            addCriterion("familyIncome >", value, "familyincome");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeGreaterThanOrEqualTo(Integer value) {
            addCriterion("familyIncome >=", value, "familyincome");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeLessThan(Integer value) {
            addCriterion("familyIncome <", value, "familyincome");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeLessThanOrEqualTo(Integer value) {
            addCriterion("familyIncome <=", value, "familyincome");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeIn(List<Integer> values) {
            addCriterion("familyIncome in", values, "familyincome");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeNotIn(List<Integer> values) {
            addCriterion("familyIncome not in", values, "familyincome");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeBetween(Integer value1, Integer value2) {
            addCriterion("familyIncome between", value1, value2, "familyincome");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeNotBetween(Integer value1, Integer value2) {
            addCriterion("familyIncome not between", value1, value2, "familyincome");
            return (Criteria) this;
        }

        public Criteria andIsloanIsNull() {
            addCriterion("isLoan is null");
            return (Criteria) this;
        }

        public Criteria andIsloanIsNotNull() {
            addCriterion("isLoan is not null");
            return (Criteria) this;
        }

        public Criteria andIsloanEqualTo(String value) {
            addCriterion("isLoan =", value, "isloan");
            return (Criteria) this;
        }

        public Criteria andIsloanNotEqualTo(String value) {
            addCriterion("isLoan <>", value, "isloan");
            return (Criteria) this;
        }

        public Criteria andIsloanGreaterThan(String value) {
            addCriterion("isLoan >", value, "isloan");
            return (Criteria) this;
        }

        public Criteria andIsloanGreaterThanOrEqualTo(String value) {
            addCriterion("isLoan >=", value, "isloan");
            return (Criteria) this;
        }

        public Criteria andIsloanLessThan(String value) {
            addCriterion("isLoan <", value, "isloan");
            return (Criteria) this;
        }

        public Criteria andIsloanLessThanOrEqualTo(String value) {
            addCriterion("isLoan <=", value, "isloan");
            return (Criteria) this;
        }

        public Criteria andIsloanLike(String value) {
            addCriterion("isLoan like", value, "isloan");
            return (Criteria) this;
        }

        public Criteria andIsloanNotLike(String value) {
            addCriterion("isLoan not like", value, "isloan");
            return (Criteria) this;
        }

        public Criteria andIsloanIn(List<String> values) {
            addCriterion("isLoan in", values, "isloan");
            return (Criteria) this;
        }

        public Criteria andIsloanNotIn(List<String> values) {
            addCriterion("isLoan not in", values, "isloan");
            return (Criteria) this;
        }

        public Criteria andIsloanBetween(String value1, String value2) {
            addCriterion("isLoan between", value1, value2, "isloan");
            return (Criteria) this;
        }

        public Criteria andIsloanNotBetween(String value1, String value2) {
            addCriterion("isLoan not between", value1, value2, "isloan");
            return (Criteria) this;
        }

        public Criteria andFworkplaceIsNull() {
            addCriterion("fworkplace is null");
            return (Criteria) this;
        }

        public Criteria andFworkplaceIsNotNull() {
            addCriterion("fworkplace is not null");
            return (Criteria) this;
        }

        public Criteria andFworkplaceEqualTo(String value) {
            addCriterion("fworkplace =", value, "fworkplace");
            return (Criteria) this;
        }

        public Criteria andFworkplaceNotEqualTo(String value) {
            addCriterion("fworkplace <>", value, "fworkplace");
            return (Criteria) this;
        }

        public Criteria andFworkplaceGreaterThan(String value) {
            addCriterion("fworkplace >", value, "fworkplace");
            return (Criteria) this;
        }

        public Criteria andFworkplaceGreaterThanOrEqualTo(String value) {
            addCriterion("fworkplace >=", value, "fworkplace");
            return (Criteria) this;
        }

        public Criteria andFworkplaceLessThan(String value) {
            addCriterion("fworkplace <", value, "fworkplace");
            return (Criteria) this;
        }

        public Criteria andFworkplaceLessThanOrEqualTo(String value) {
            addCriterion("fworkplace <=", value, "fworkplace");
            return (Criteria) this;
        }

        public Criteria andFworkplaceLike(String value) {
            addCriterion("fworkplace like", value, "fworkplace");
            return (Criteria) this;
        }

        public Criteria andFworkplaceNotLike(String value) {
            addCriterion("fworkplace not like", value, "fworkplace");
            return (Criteria) this;
        }

        public Criteria andFworkplaceIn(List<String> values) {
            addCriterion("fworkplace in", values, "fworkplace");
            return (Criteria) this;
        }

        public Criteria andFworkplaceNotIn(List<String> values) {
            addCriterion("fworkplace not in", values, "fworkplace");
            return (Criteria) this;
        }

        public Criteria andFworkplaceBetween(String value1, String value2) {
            addCriterion("fworkplace between", value1, value2, "fworkplace");
            return (Criteria) this;
        }

        public Criteria andFworkplaceNotBetween(String value1, String value2) {
            addCriterion("fworkplace not between", value1, value2, "fworkplace");
            return (Criteria) this;
        }

        public Criteria andFearningIsNull() {
            addCriterion("fEarning is null");
            return (Criteria) this;
        }

        public Criteria andFearningIsNotNull() {
            addCriterion("fEarning is not null");
            return (Criteria) this;
        }

        public Criteria andFearningEqualTo(String value) {
            addCriterion("fEarning =", value, "fearning");
            return (Criteria) this;
        }

        public Criteria andFearningNotEqualTo(String value) {
            addCriterion("fEarning <>", value, "fearning");
            return (Criteria) this;
        }

        public Criteria andFearningGreaterThan(String value) {
            addCriterion("fEarning >", value, "fearning");
            return (Criteria) this;
        }

        public Criteria andFearningGreaterThanOrEqualTo(String value) {
            addCriterion("fEarning >=", value, "fearning");
            return (Criteria) this;
        }

        public Criteria andFearningLessThan(String value) {
            addCriterion("fEarning <", value, "fearning");
            return (Criteria) this;
        }

        public Criteria andFearningLessThanOrEqualTo(String value) {
            addCriterion("fEarning <=", value, "fearning");
            return (Criteria) this;
        }

        public Criteria andFearningLike(String value) {
            addCriterion("fEarning like", value, "fearning");
            return (Criteria) this;
        }

        public Criteria andFearningNotLike(String value) {
            addCriterion("fEarning not like", value, "fearning");
            return (Criteria) this;
        }

        public Criteria andFearningIn(List<String> values) {
            addCriterion("fEarning in", values, "fearning");
            return (Criteria) this;
        }

        public Criteria andFearningNotIn(List<String> values) {
            addCriterion("fEarning not in", values, "fearning");
            return (Criteria) this;
        }

        public Criteria andFearningBetween(String value1, String value2) {
            addCriterion("fEarning between", value1, value2, "fearning");
            return (Criteria) this;
        }

        public Criteria andFearningNotBetween(String value1, String value2) {
            addCriterion("fEarning not between", value1, value2, "fearning");
            return (Criteria) this;
        }

        public Criteria andMworkplaceIsNull() {
            addCriterion("mworkplace is null");
            return (Criteria) this;
        }

        public Criteria andMworkplaceIsNotNull() {
            addCriterion("mworkplace is not null");
            return (Criteria) this;
        }

        public Criteria andMworkplaceEqualTo(String value) {
            addCriterion("mworkplace =", value, "mworkplace");
            return (Criteria) this;
        }

        public Criteria andMworkplaceNotEqualTo(String value) {
            addCriterion("mworkplace <>", value, "mworkplace");
            return (Criteria) this;
        }

        public Criteria andMworkplaceGreaterThan(String value) {
            addCriterion("mworkplace >", value, "mworkplace");
            return (Criteria) this;
        }

        public Criteria andMworkplaceGreaterThanOrEqualTo(String value) {
            addCriterion("mworkplace >=", value, "mworkplace");
            return (Criteria) this;
        }

        public Criteria andMworkplaceLessThan(String value) {
            addCriterion("mworkplace <", value, "mworkplace");
            return (Criteria) this;
        }

        public Criteria andMworkplaceLessThanOrEqualTo(String value) {
            addCriterion("mworkplace <=", value, "mworkplace");
            return (Criteria) this;
        }

        public Criteria andMworkplaceLike(String value) {
            addCriterion("mworkplace like", value, "mworkplace");
            return (Criteria) this;
        }

        public Criteria andMworkplaceNotLike(String value) {
            addCriterion("mworkplace not like", value, "mworkplace");
            return (Criteria) this;
        }

        public Criteria andMworkplaceIn(List<String> values) {
            addCriterion("mworkplace in", values, "mworkplace");
            return (Criteria) this;
        }

        public Criteria andMworkplaceNotIn(List<String> values) {
            addCriterion("mworkplace not in", values, "mworkplace");
            return (Criteria) this;
        }

        public Criteria andMworkplaceBetween(String value1, String value2) {
            addCriterion("mworkplace between", value1, value2, "mworkplace");
            return (Criteria) this;
        }

        public Criteria andMworkplaceNotBetween(String value1, String value2) {
            addCriterion("mworkplace not between", value1, value2, "mworkplace");
            return (Criteria) this;
        }

        public Criteria andMearningIsNull() {
            addCriterion("mEarning is null");
            return (Criteria) this;
        }

        public Criteria andMearningIsNotNull() {
            addCriterion("mEarning is not null");
            return (Criteria) this;
        }

        public Criteria andMearningEqualTo(String value) {
            addCriterion("mEarning =", value, "mearning");
            return (Criteria) this;
        }

        public Criteria andMearningNotEqualTo(String value) {
            addCriterion("mEarning <>", value, "mearning");
            return (Criteria) this;
        }

        public Criteria andMearningGreaterThan(String value) {
            addCriterion("mEarning >", value, "mearning");
            return (Criteria) this;
        }

        public Criteria andMearningGreaterThanOrEqualTo(String value) {
            addCriterion("mEarning >=", value, "mearning");
            return (Criteria) this;
        }

        public Criteria andMearningLessThan(String value) {
            addCriterion("mEarning <", value, "mearning");
            return (Criteria) this;
        }

        public Criteria andMearningLessThanOrEqualTo(String value) {
            addCriterion("mEarning <=", value, "mearning");
            return (Criteria) this;
        }

        public Criteria andMearningLike(String value) {
            addCriterion("mEarning like", value, "mearning");
            return (Criteria) this;
        }

        public Criteria andMearningNotLike(String value) {
            addCriterion("mEarning not like", value, "mearning");
            return (Criteria) this;
        }

        public Criteria andMearningIn(List<String> values) {
            addCriterion("mEarning in", values, "mearning");
            return (Criteria) this;
        }

        public Criteria andMearningNotIn(List<String> values) {
            addCriterion("mEarning not in", values, "mearning");
            return (Criteria) this;
        }

        public Criteria andMearningBetween(String value1, String value2) {
            addCriterion("mEarning between", value1, value2, "mearning");
            return (Criteria) this;
        }

        public Criteria andMearningNotBetween(String value1, String value2) {
            addCriterion("mEarning not between", value1, value2, "mearning");
            return (Criteria) this;
        }

        public Criteria andPopulationIsNull() {
            addCriterion("population is null");
            return (Criteria) this;
        }

        public Criteria andPopulationIsNotNull() {
            addCriterion("population is not null");
            return (Criteria) this;
        }

        public Criteria andPopulationEqualTo(Integer value) {
            addCriterion("population =", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationNotEqualTo(Integer value) {
            addCriterion("population <>", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationGreaterThan(Integer value) {
            addCriterion("population >", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationGreaterThanOrEqualTo(Integer value) {
            addCriterion("population >=", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationLessThan(Integer value) {
            addCriterion("population <", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationLessThanOrEqualTo(Integer value) {
            addCriterion("population <=", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationIn(List<Integer> values) {
            addCriterion("population in", values, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationNotIn(List<Integer> values) {
            addCriterion("population not in", values, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationBetween(Integer value1, Integer value2) {
            addCriterion("population between", value1, value2, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationNotBetween(Integer value1, Integer value2) {
            addCriterion("population not between", value1, value2, "population");
            return (Criteria) this;
        }

        public Criteria andApplicationIsNull() {
            addCriterion("application is null");
            return (Criteria) this;
        }

        public Criteria andApplicationIsNotNull() {
            addCriterion("application is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationEqualTo(String value) {
            addCriterion("application =", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotEqualTo(String value) {
            addCriterion("application <>", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationGreaterThan(String value) {
            addCriterion("application >", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationGreaterThanOrEqualTo(String value) {
            addCriterion("application >=", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationLessThan(String value) {
            addCriterion("application <", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationLessThanOrEqualTo(String value) {
            addCriterion("application <=", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationLike(String value) {
            addCriterion("application like", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotLike(String value) {
            addCriterion("application not like", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationIn(List<String> values) {
            addCriterion("application in", values, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotIn(List<String> values) {
            addCriterion("application not in", values, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationBetween(String value1, String value2) {
            addCriterion("application between", value1, value2, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotBetween(String value1, String value2) {
            addCriterion("application not between", value1, value2, "application");
            return (Criteria) this;
        }

        public Criteria andPoorproveIsNull() {
            addCriterion("poorProve is null");
            return (Criteria) this;
        }

        public Criteria andPoorproveIsNotNull() {
            addCriterion("poorProve is not null");
            return (Criteria) this;
        }

        public Criteria andPoorproveEqualTo(String value) {
            addCriterion("poorProve =", value, "poorprove");
            return (Criteria) this;
        }

        public Criteria andPoorproveNotEqualTo(String value) {
            addCriterion("poorProve <>", value, "poorprove");
            return (Criteria) this;
        }

        public Criteria andPoorproveGreaterThan(String value) {
            addCriterion("poorProve >", value, "poorprove");
            return (Criteria) this;
        }

        public Criteria andPoorproveGreaterThanOrEqualTo(String value) {
            addCriterion("poorProve >=", value, "poorprove");
            return (Criteria) this;
        }

        public Criteria andPoorproveLessThan(String value) {
            addCriterion("poorProve <", value, "poorprove");
            return (Criteria) this;
        }

        public Criteria andPoorproveLessThanOrEqualTo(String value) {
            addCriterion("poorProve <=", value, "poorprove");
            return (Criteria) this;
        }

        public Criteria andPoorproveLike(String value) {
            addCriterion("poorProve like", value, "poorprove");
            return (Criteria) this;
        }

        public Criteria andPoorproveNotLike(String value) {
            addCriterion("poorProve not like", value, "poorprove");
            return (Criteria) this;
        }

        public Criteria andPoorproveIn(List<String> values) {
            addCriterion("poorProve in", values, "poorprove");
            return (Criteria) this;
        }

        public Criteria andPoorproveNotIn(List<String> values) {
            addCriterion("poorProve not in", values, "poorprove");
            return (Criteria) this;
        }

        public Criteria andPoorproveBetween(String value1, String value2) {
            addCriterion("poorProve between", value1, value2, "poorprove");
            return (Criteria) this;
        }

        public Criteria andPoorproveNotBetween(String value1, String value2) {
            addCriterion("poorProve not between", value1, value2, "poorprove");
            return (Criteria) this;
        }

        public Criteria andRetireproveIsNull() {
            addCriterion("retireProve is null");
            return (Criteria) this;
        }

        public Criteria andRetireproveIsNotNull() {
            addCriterion("retireProve is not null");
            return (Criteria) this;
        }

        public Criteria andRetireproveEqualTo(String value) {
            addCriterion("retireProve =", value, "retireprove");
            return (Criteria) this;
        }

        public Criteria andRetireproveNotEqualTo(String value) {
            addCriterion("retireProve <>", value, "retireprove");
            return (Criteria) this;
        }

        public Criteria andRetireproveGreaterThan(String value) {
            addCriterion("retireProve >", value, "retireprove");
            return (Criteria) this;
        }

        public Criteria andRetireproveGreaterThanOrEqualTo(String value) {
            addCriterion("retireProve >=", value, "retireprove");
            return (Criteria) this;
        }

        public Criteria andRetireproveLessThan(String value) {
            addCriterion("retireProve <", value, "retireprove");
            return (Criteria) this;
        }

        public Criteria andRetireproveLessThanOrEqualTo(String value) {
            addCriterion("retireProve <=", value, "retireprove");
            return (Criteria) this;
        }

        public Criteria andRetireproveLike(String value) {
            addCriterion("retireProve like", value, "retireprove");
            return (Criteria) this;
        }

        public Criteria andRetireproveNotLike(String value) {
            addCriterion("retireProve not like", value, "retireprove");
            return (Criteria) this;
        }

        public Criteria andRetireproveIn(List<String> values) {
            addCriterion("retireProve in", values, "retireprove");
            return (Criteria) this;
        }

        public Criteria andRetireproveNotIn(List<String> values) {
            addCriterion("retireProve not in", values, "retireprove");
            return (Criteria) this;
        }

        public Criteria andRetireproveBetween(String value1, String value2) {
            addCriterion("retireProve between", value1, value2, "retireprove");
            return (Criteria) this;
        }

        public Criteria andRetireproveNotBetween(String value1, String value2) {
            addCriterion("retireProve not between", value1, value2, "retireprove");
            return (Criteria) this;
        }

        public Criteria andDeformityproveIsNull() {
            addCriterion("deformityProve is null");
            return (Criteria) this;
        }

        public Criteria andDeformityproveIsNotNull() {
            addCriterion("deformityProve is not null");
            return (Criteria) this;
        }

        public Criteria andDeformityproveEqualTo(String value) {
            addCriterion("deformityProve =", value, "deformityprove");
            return (Criteria) this;
        }

        public Criteria andDeformityproveNotEqualTo(String value) {
            addCriterion("deformityProve <>", value, "deformityprove");
            return (Criteria) this;
        }

        public Criteria andDeformityproveGreaterThan(String value) {
            addCriterion("deformityProve >", value, "deformityprove");
            return (Criteria) this;
        }

        public Criteria andDeformityproveGreaterThanOrEqualTo(String value) {
            addCriterion("deformityProve >=", value, "deformityprove");
            return (Criteria) this;
        }

        public Criteria andDeformityproveLessThan(String value) {
            addCriterion("deformityProve <", value, "deformityprove");
            return (Criteria) this;
        }

        public Criteria andDeformityproveLessThanOrEqualTo(String value) {
            addCriterion("deformityProve <=", value, "deformityprove");
            return (Criteria) this;
        }

        public Criteria andDeformityproveLike(String value) {
            addCriterion("deformityProve like", value, "deformityprove");
            return (Criteria) this;
        }

        public Criteria andDeformityproveNotLike(String value) {
            addCriterion("deformityProve not like", value, "deformityprove");
            return (Criteria) this;
        }

        public Criteria andDeformityproveIn(List<String> values) {
            addCriterion("deformityProve in", values, "deformityprove");
            return (Criteria) this;
        }

        public Criteria andDeformityproveNotIn(List<String> values) {
            addCriterion("deformityProve not in", values, "deformityprove");
            return (Criteria) this;
        }

        public Criteria andDeformityproveBetween(String value1, String value2) {
            addCriterion("deformityProve between", value1, value2, "deformityprove");
            return (Criteria) this;
        }

        public Criteria andDeformityproveNotBetween(String value1, String value2) {
            addCriterion("deformityProve not between", value1, value2, "deformityprove");
            return (Criteria) this;
        }

        public Criteria andEfficiencyproveIsNull() {
            addCriterion("efficiencyProve is null");
            return (Criteria) this;
        }

        public Criteria andEfficiencyproveIsNotNull() {
            addCriterion("efficiencyProve is not null");
            return (Criteria) this;
        }

        public Criteria andEfficiencyproveEqualTo(String value) {
            addCriterion("efficiencyProve =", value, "efficiencyprove");
            return (Criteria) this;
        }

        public Criteria andEfficiencyproveNotEqualTo(String value) {
            addCriterion("efficiencyProve <>", value, "efficiencyprove");
            return (Criteria) this;
        }

        public Criteria andEfficiencyproveGreaterThan(String value) {
            addCriterion("efficiencyProve >", value, "efficiencyprove");
            return (Criteria) this;
        }

        public Criteria andEfficiencyproveGreaterThanOrEqualTo(String value) {
            addCriterion("efficiencyProve >=", value, "efficiencyprove");
            return (Criteria) this;
        }

        public Criteria andEfficiencyproveLessThan(String value) {
            addCriterion("efficiencyProve <", value, "efficiencyprove");
            return (Criteria) this;
        }

        public Criteria andEfficiencyproveLessThanOrEqualTo(String value) {
            addCriterion("efficiencyProve <=", value, "efficiencyprove");
            return (Criteria) this;
        }

        public Criteria andEfficiencyproveLike(String value) {
            addCriterion("efficiencyProve like", value, "efficiencyprove");
            return (Criteria) this;
        }

        public Criteria andEfficiencyproveNotLike(String value) {
            addCriterion("efficiencyProve not like", value, "efficiencyprove");
            return (Criteria) this;
        }

        public Criteria andEfficiencyproveIn(List<String> values) {
            addCriterion("efficiencyProve in", values, "efficiencyprove");
            return (Criteria) this;
        }

        public Criteria andEfficiencyproveNotIn(List<String> values) {
            addCriterion("efficiencyProve not in", values, "efficiencyprove");
            return (Criteria) this;
        }

        public Criteria andEfficiencyproveBetween(String value1, String value2) {
            addCriterion("efficiencyProve between", value1, value2, "efficiencyprove");
            return (Criteria) this;
        }

        public Criteria andEfficiencyproveNotBetween(String value1, String value2) {
            addCriterion("efficiencyProve not between", value1, value2, "efficiencyprove");
            return (Criteria) this;
        }

        public Criteria andConditionproveIsNull() {
            addCriterion("conditionProve is null");
            return (Criteria) this;
        }

        public Criteria andConditionproveIsNotNull() {
            addCriterion("conditionProve is not null");
            return (Criteria) this;
        }

        public Criteria andConditionproveEqualTo(String value) {
            addCriterion("conditionProve =", value, "conditionprove");
            return (Criteria) this;
        }

        public Criteria andConditionproveNotEqualTo(String value) {
            addCriterion("conditionProve <>", value, "conditionprove");
            return (Criteria) this;
        }

        public Criteria andConditionproveGreaterThan(String value) {
            addCriterion("conditionProve >", value, "conditionprove");
            return (Criteria) this;
        }

        public Criteria andConditionproveGreaterThanOrEqualTo(String value) {
            addCriterion("conditionProve >=", value, "conditionprove");
            return (Criteria) this;
        }

        public Criteria andConditionproveLessThan(String value) {
            addCriterion("conditionProve <", value, "conditionprove");
            return (Criteria) this;
        }

        public Criteria andConditionproveLessThanOrEqualTo(String value) {
            addCriterion("conditionProve <=", value, "conditionprove");
            return (Criteria) this;
        }

        public Criteria andConditionproveLike(String value) {
            addCriterion("conditionProve like", value, "conditionprove");
            return (Criteria) this;
        }

        public Criteria andConditionproveNotLike(String value) {
            addCriterion("conditionProve not like", value, "conditionprove");
            return (Criteria) this;
        }

        public Criteria andConditionproveIn(List<String> values) {
            addCriterion("conditionProve in", values, "conditionprove");
            return (Criteria) this;
        }

        public Criteria andConditionproveNotIn(List<String> values) {
            addCriterion("conditionProve not in", values, "conditionprove");
            return (Criteria) this;
        }

        public Criteria andConditionproveBetween(String value1, String value2) {
            addCriterion("conditionProve between", value1, value2, "conditionprove");
            return (Criteria) this;
        }

        public Criteria andConditionproveNotBetween(String value1, String value2) {
            addCriterion("conditionProve not between", value1, value2, "conditionprove");
            return (Criteria) this;
        }

        public Criteria andAwardsproveIsNull() {
            addCriterion("awardsProve is null");
            return (Criteria) this;
        }

        public Criteria andAwardsproveIsNotNull() {
            addCriterion("awardsProve is not null");
            return (Criteria) this;
        }

        public Criteria andAwardsproveEqualTo(String value) {
            addCriterion("awardsProve =", value, "awardsprove");
            return (Criteria) this;
        }

        public Criteria andAwardsproveNotEqualTo(String value) {
            addCriterion("awardsProve <>", value, "awardsprove");
            return (Criteria) this;
        }

        public Criteria andAwardsproveGreaterThan(String value) {
            addCriterion("awardsProve >", value, "awardsprove");
            return (Criteria) this;
        }

        public Criteria andAwardsproveGreaterThanOrEqualTo(String value) {
            addCriterion("awardsProve >=", value, "awardsprove");
            return (Criteria) this;
        }

        public Criteria andAwardsproveLessThan(String value) {
            addCriterion("awardsProve <", value, "awardsprove");
            return (Criteria) this;
        }

        public Criteria andAwardsproveLessThanOrEqualTo(String value) {
            addCriterion("awardsProve <=", value, "awardsprove");
            return (Criteria) this;
        }

        public Criteria andAwardsproveLike(String value) {
            addCriterion("awardsProve like", value, "awardsprove");
            return (Criteria) this;
        }

        public Criteria andAwardsproveNotLike(String value) {
            addCriterion("awardsProve not like", value, "awardsprove");
            return (Criteria) this;
        }

        public Criteria andAwardsproveIn(List<String> values) {
            addCriterion("awardsProve in", values, "awardsprove");
            return (Criteria) this;
        }

        public Criteria andAwardsproveNotIn(List<String> values) {
            addCriterion("awardsProve not in", values, "awardsprove");
            return (Criteria) this;
        }

        public Criteria andAwardsproveBetween(String value1, String value2) {
            addCriterion("awardsProve between", value1, value2, "awardsprove");
            return (Criteria) this;
        }

        public Criteria andAwardsproveNotBetween(String value1, String value2) {
            addCriterion("awardsProve not between", value1, value2, "awardsprove");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andM1IsNull() {
            addCriterion("m1 is null");
            return (Criteria) this;
        }

        public Criteria andM1IsNotNull() {
            addCriterion("m1 is not null");
            return (Criteria) this;
        }

        public Criteria andM1EqualTo(String value) {
            addCriterion("m1 =", value, "m1");
            return (Criteria) this;
        }

        public Criteria andM1NotEqualTo(String value) {
            addCriterion("m1 <>", value, "m1");
            return (Criteria) this;
        }

        public Criteria andM1GreaterThan(String value) {
            addCriterion("m1 >", value, "m1");
            return (Criteria) this;
        }

        public Criteria andM1GreaterThanOrEqualTo(String value) {
            addCriterion("m1 >=", value, "m1");
            return (Criteria) this;
        }

        public Criteria andM1LessThan(String value) {
            addCriterion("m1 <", value, "m1");
            return (Criteria) this;
        }

        public Criteria andM1LessThanOrEqualTo(String value) {
            addCriterion("m1 <=", value, "m1");
            return (Criteria) this;
        }

        public Criteria andM1Like(String value) {
            addCriterion("m1 like", value, "m1");
            return (Criteria) this;
        }

        public Criteria andM1NotLike(String value) {
            addCriterion("m1 not like", value, "m1");
            return (Criteria) this;
        }

        public Criteria andM1In(List<String> values) {
            addCriterion("m1 in", values, "m1");
            return (Criteria) this;
        }

        public Criteria andM1NotIn(List<String> values) {
            addCriterion("m1 not in", values, "m1");
            return (Criteria) this;
        }

        public Criteria andM1Between(String value1, String value2) {
            addCriterion("m1 between", value1, value2, "m1");
            return (Criteria) this;
        }

        public Criteria andM1NotBetween(String value1, String value2) {
            addCriterion("m1 not between", value1, value2, "m1");
            return (Criteria) this;
        }

        public Criteria andM1nameIsNull() {
            addCriterion("m1name is null");
            return (Criteria) this;
        }

        public Criteria andM1nameIsNotNull() {
            addCriterion("m1name is not null");
            return (Criteria) this;
        }

        public Criteria andM1nameEqualTo(String value) {
            addCriterion("m1name =", value, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameNotEqualTo(String value) {
            addCriterion("m1name <>", value, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameGreaterThan(String value) {
            addCriterion("m1name >", value, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameGreaterThanOrEqualTo(String value) {
            addCriterion("m1name >=", value, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameLessThan(String value) {
            addCriterion("m1name <", value, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameLessThanOrEqualTo(String value) {
            addCriterion("m1name <=", value, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameLike(String value) {
            addCriterion("m1name like", value, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameNotLike(String value) {
            addCriterion("m1name not like", value, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameIn(List<String> values) {
            addCriterion("m1name in", values, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameNotIn(List<String> values) {
            addCriterion("m1name not in", values, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameBetween(String value1, String value2) {
            addCriterion("m1name between", value1, value2, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1nameNotBetween(String value1, String value2) {
            addCriterion("m1name not between", value1, value2, "m1name");
            return (Criteria) this;
        }

        public Criteria andM1workplaceIsNull() {
            addCriterion("m1workplace is null");
            return (Criteria) this;
        }

        public Criteria andM1workplaceIsNotNull() {
            addCriterion("m1workplace is not null");
            return (Criteria) this;
        }

        public Criteria andM1workplaceEqualTo(String value) {
            addCriterion("m1workplace =", value, "m1workplace");
            return (Criteria) this;
        }

        public Criteria andM1workplaceNotEqualTo(String value) {
            addCriterion("m1workplace <>", value, "m1workplace");
            return (Criteria) this;
        }

        public Criteria andM1workplaceGreaterThan(String value) {
            addCriterion("m1workplace >", value, "m1workplace");
            return (Criteria) this;
        }

        public Criteria andM1workplaceGreaterThanOrEqualTo(String value) {
            addCriterion("m1workplace >=", value, "m1workplace");
            return (Criteria) this;
        }

        public Criteria andM1workplaceLessThan(String value) {
            addCriterion("m1workplace <", value, "m1workplace");
            return (Criteria) this;
        }

        public Criteria andM1workplaceLessThanOrEqualTo(String value) {
            addCriterion("m1workplace <=", value, "m1workplace");
            return (Criteria) this;
        }

        public Criteria andM1workplaceLike(String value) {
            addCriterion("m1workplace like", value, "m1workplace");
            return (Criteria) this;
        }

        public Criteria andM1workplaceNotLike(String value) {
            addCriterion("m1workplace not like", value, "m1workplace");
            return (Criteria) this;
        }

        public Criteria andM1workplaceIn(List<String> values) {
            addCriterion("m1workplace in", values, "m1workplace");
            return (Criteria) this;
        }

        public Criteria andM1workplaceNotIn(List<String> values) {
            addCriterion("m1workplace not in", values, "m1workplace");
            return (Criteria) this;
        }

        public Criteria andM1workplaceBetween(String value1, String value2) {
            addCriterion("m1workplace between", value1, value2, "m1workplace");
            return (Criteria) this;
        }

        public Criteria andM1workplaceNotBetween(String value1, String value2) {
            addCriterion("m1workplace not between", value1, value2, "m1workplace");
            return (Criteria) this;
        }

        public Criteria andM1earningIsNull() {
            addCriterion("m1Earning is null");
            return (Criteria) this;
        }

        public Criteria andM1earningIsNotNull() {
            addCriterion("m1Earning is not null");
            return (Criteria) this;
        }

        public Criteria andM1earningEqualTo(String value) {
            addCriterion("m1Earning =", value, "m1earning");
            return (Criteria) this;
        }

        public Criteria andM1earningNotEqualTo(String value) {
            addCriterion("m1Earning <>", value, "m1earning");
            return (Criteria) this;
        }

        public Criteria andM1earningGreaterThan(String value) {
            addCriterion("m1Earning >", value, "m1earning");
            return (Criteria) this;
        }

        public Criteria andM1earningGreaterThanOrEqualTo(String value) {
            addCriterion("m1Earning >=", value, "m1earning");
            return (Criteria) this;
        }

        public Criteria andM1earningLessThan(String value) {
            addCriterion("m1Earning <", value, "m1earning");
            return (Criteria) this;
        }

        public Criteria andM1earningLessThanOrEqualTo(String value) {
            addCriterion("m1Earning <=", value, "m1earning");
            return (Criteria) this;
        }

        public Criteria andM1earningLike(String value) {
            addCriterion("m1Earning like", value, "m1earning");
            return (Criteria) this;
        }

        public Criteria andM1earningNotLike(String value) {
            addCriterion("m1Earning not like", value, "m1earning");
            return (Criteria) this;
        }

        public Criteria andM1earningIn(List<String> values) {
            addCriterion("m1Earning in", values, "m1earning");
            return (Criteria) this;
        }

        public Criteria andM1earningNotIn(List<String> values) {
            addCriterion("m1Earning not in", values, "m1earning");
            return (Criteria) this;
        }

        public Criteria andM1earningBetween(String value1, String value2) {
            addCriterion("m1Earning between", value1, value2, "m1earning");
            return (Criteria) this;
        }

        public Criteria andM1earningNotBetween(String value1, String value2) {
            addCriterion("m1Earning not between", value1, value2, "m1earning");
            return (Criteria) this;
        }

        public Criteria andM2IsNull() {
            addCriterion("m2 is null");
            return (Criteria) this;
        }

        public Criteria andM2IsNotNull() {
            addCriterion("m2 is not null");
            return (Criteria) this;
        }

        public Criteria andM2EqualTo(String value) {
            addCriterion("m2 =", value, "m2");
            return (Criteria) this;
        }

        public Criteria andM2NotEqualTo(String value) {
            addCriterion("m2 <>", value, "m2");
            return (Criteria) this;
        }

        public Criteria andM2GreaterThan(String value) {
            addCriterion("m2 >", value, "m2");
            return (Criteria) this;
        }

        public Criteria andM2GreaterThanOrEqualTo(String value) {
            addCriterion("m2 >=", value, "m2");
            return (Criteria) this;
        }

        public Criteria andM2LessThan(String value) {
            addCriterion("m2 <", value, "m2");
            return (Criteria) this;
        }

        public Criteria andM2LessThanOrEqualTo(String value) {
            addCriterion("m2 <=", value, "m2");
            return (Criteria) this;
        }

        public Criteria andM2Like(String value) {
            addCriterion("m2 like", value, "m2");
            return (Criteria) this;
        }

        public Criteria andM2NotLike(String value) {
            addCriterion("m2 not like", value, "m2");
            return (Criteria) this;
        }

        public Criteria andM2In(List<String> values) {
            addCriterion("m2 in", values, "m2");
            return (Criteria) this;
        }

        public Criteria andM2NotIn(List<String> values) {
            addCriterion("m2 not in", values, "m2");
            return (Criteria) this;
        }

        public Criteria andM2Between(String value1, String value2) {
            addCriterion("m2 between", value1, value2, "m2");
            return (Criteria) this;
        }

        public Criteria andM2NotBetween(String value1, String value2) {
            addCriterion("m2 not between", value1, value2, "m2");
            return (Criteria) this;
        }

        public Criteria andM2nameIsNull() {
            addCriterion("m2name is null");
            return (Criteria) this;
        }

        public Criteria andM2nameIsNotNull() {
            addCriterion("m2name is not null");
            return (Criteria) this;
        }

        public Criteria andM2nameEqualTo(String value) {
            addCriterion("m2name =", value, "m2name");
            return (Criteria) this;
        }

        public Criteria andM2nameNotEqualTo(String value) {
            addCriterion("m2name <>", value, "m2name");
            return (Criteria) this;
        }

        public Criteria andM2nameGreaterThan(String value) {
            addCriterion("m2name >", value, "m2name");
            return (Criteria) this;
        }

        public Criteria andM2nameGreaterThanOrEqualTo(String value) {
            addCriterion("m2name >=", value, "m2name");
            return (Criteria) this;
        }

        public Criteria andM2nameLessThan(String value) {
            addCriterion("m2name <", value, "m2name");
            return (Criteria) this;
        }

        public Criteria andM2nameLessThanOrEqualTo(String value) {
            addCriterion("m2name <=", value, "m2name");
            return (Criteria) this;
        }

        public Criteria andM2nameLike(String value) {
            addCriterion("m2name like", value, "m2name");
            return (Criteria) this;
        }

        public Criteria andM2nameNotLike(String value) {
            addCriterion("m2name not like", value, "m2name");
            return (Criteria) this;
        }

        public Criteria andM2nameIn(List<String> values) {
            addCriterion("m2name in", values, "m2name");
            return (Criteria) this;
        }

        public Criteria andM2nameNotIn(List<String> values) {
            addCriterion("m2name not in", values, "m2name");
            return (Criteria) this;
        }

        public Criteria andM2nameBetween(String value1, String value2) {
            addCriterion("m2name between", value1, value2, "m2name");
            return (Criteria) this;
        }

        public Criteria andM2nameNotBetween(String value1, String value2) {
            addCriterion("m2name not between", value1, value2, "m2name");
            return (Criteria) this;
        }

        public Criteria andM2wordpressIsNull() {
            addCriterion("m2wordpress is null");
            return (Criteria) this;
        }

        public Criteria andM2wordpressIsNotNull() {
            addCriterion("m2wordpress is not null");
            return (Criteria) this;
        }

        public Criteria andM2wordpressEqualTo(String value) {
            addCriterion("m2wordpress =", value, "m2wordpress");
            return (Criteria) this;
        }

        public Criteria andM2wordpressNotEqualTo(String value) {
            addCriterion("m2wordpress <>", value, "m2wordpress");
            return (Criteria) this;
        }

        public Criteria andM2wordpressGreaterThan(String value) {
            addCriterion("m2wordpress >", value, "m2wordpress");
            return (Criteria) this;
        }

        public Criteria andM2wordpressGreaterThanOrEqualTo(String value) {
            addCriterion("m2wordpress >=", value, "m2wordpress");
            return (Criteria) this;
        }

        public Criteria andM2wordpressLessThan(String value) {
            addCriterion("m2wordpress <", value, "m2wordpress");
            return (Criteria) this;
        }

        public Criteria andM2wordpressLessThanOrEqualTo(String value) {
            addCriterion("m2wordpress <=", value, "m2wordpress");
            return (Criteria) this;
        }

        public Criteria andM2wordpressLike(String value) {
            addCriterion("m2wordpress like", value, "m2wordpress");
            return (Criteria) this;
        }

        public Criteria andM2wordpressNotLike(String value) {
            addCriterion("m2wordpress not like", value, "m2wordpress");
            return (Criteria) this;
        }

        public Criteria andM2wordpressIn(List<String> values) {
            addCriterion("m2wordpress in", values, "m2wordpress");
            return (Criteria) this;
        }

        public Criteria andM2wordpressNotIn(List<String> values) {
            addCriterion("m2wordpress not in", values, "m2wordpress");
            return (Criteria) this;
        }

        public Criteria andM2wordpressBetween(String value1, String value2) {
            addCriterion("m2wordpress between", value1, value2, "m2wordpress");
            return (Criteria) this;
        }

        public Criteria andM2wordpressNotBetween(String value1, String value2) {
            addCriterion("m2wordpress not between", value1, value2, "m2wordpress");
            return (Criteria) this;
        }

        public Criteria andM2earningIsNull() {
            addCriterion("m2Earning is null");
            return (Criteria) this;
        }

        public Criteria andM2earningIsNotNull() {
            addCriterion("m2Earning is not null");
            return (Criteria) this;
        }

        public Criteria andM2earningEqualTo(String value) {
            addCriterion("m2Earning =", value, "m2earning");
            return (Criteria) this;
        }

        public Criteria andM2earningNotEqualTo(String value) {
            addCriterion("m2Earning <>", value, "m2earning");
            return (Criteria) this;
        }

        public Criteria andM2earningGreaterThan(String value) {
            addCriterion("m2Earning >", value, "m2earning");
            return (Criteria) this;
        }

        public Criteria andM2earningGreaterThanOrEqualTo(String value) {
            addCriterion("m2Earning >=", value, "m2earning");
            return (Criteria) this;
        }

        public Criteria andM2earningLessThan(String value) {
            addCriterion("m2Earning <", value, "m2earning");
            return (Criteria) this;
        }

        public Criteria andM2earningLessThanOrEqualTo(String value) {
            addCriterion("m2Earning <=", value, "m2earning");
            return (Criteria) this;
        }

        public Criteria andM2earningLike(String value) {
            addCriterion("m2Earning like", value, "m2earning");
            return (Criteria) this;
        }

        public Criteria andM2earningNotLike(String value) {
            addCriterion("m2Earning not like", value, "m2earning");
            return (Criteria) this;
        }

        public Criteria andM2earningIn(List<String> values) {
            addCriterion("m2Earning in", values, "m2earning");
            return (Criteria) this;
        }

        public Criteria andM2earningNotIn(List<String> values) {
            addCriterion("m2Earning not in", values, "m2earning");
            return (Criteria) this;
        }

        public Criteria andM2earningBetween(String value1, String value2) {
            addCriterion("m2Earning between", value1, value2, "m2earning");
            return (Criteria) this;
        }

        public Criteria andM2earningNotBetween(String value1, String value2) {
            addCriterion("m2Earning not between", value1, value2, "m2earning");
            return (Criteria) this;
        }

        public Criteria andM3IsNull() {
            addCriterion("m3 is null");
            return (Criteria) this;
        }

        public Criteria andM3IsNotNull() {
            addCriterion("m3 is not null");
            return (Criteria) this;
        }

        public Criteria andM3EqualTo(String value) {
            addCriterion("m3 =", value, "m3");
            return (Criteria) this;
        }

        public Criteria andM3NotEqualTo(String value) {
            addCriterion("m3 <>", value, "m3");
            return (Criteria) this;
        }

        public Criteria andM3GreaterThan(String value) {
            addCriterion("m3 >", value, "m3");
            return (Criteria) this;
        }

        public Criteria andM3GreaterThanOrEqualTo(String value) {
            addCriterion("m3 >=", value, "m3");
            return (Criteria) this;
        }

        public Criteria andM3LessThan(String value) {
            addCriterion("m3 <", value, "m3");
            return (Criteria) this;
        }

        public Criteria andM3LessThanOrEqualTo(String value) {
            addCriterion("m3 <=", value, "m3");
            return (Criteria) this;
        }

        public Criteria andM3Like(String value) {
            addCriterion("m3 like", value, "m3");
            return (Criteria) this;
        }

        public Criteria andM3NotLike(String value) {
            addCriterion("m3 not like", value, "m3");
            return (Criteria) this;
        }

        public Criteria andM3In(List<String> values) {
            addCriterion("m3 in", values, "m3");
            return (Criteria) this;
        }

        public Criteria andM3NotIn(List<String> values) {
            addCriterion("m3 not in", values, "m3");
            return (Criteria) this;
        }

        public Criteria andM3Between(String value1, String value2) {
            addCriterion("m3 between", value1, value2, "m3");
            return (Criteria) this;
        }

        public Criteria andM3NotBetween(String value1, String value2) {
            addCriterion("m3 not between", value1, value2, "m3");
            return (Criteria) this;
        }

        public Criteria andM3nameIsNull() {
            addCriterion("m3name is null");
            return (Criteria) this;
        }

        public Criteria andM3nameIsNotNull() {
            addCriterion("m3name is not null");
            return (Criteria) this;
        }

        public Criteria andM3nameEqualTo(String value) {
            addCriterion("m3name =", value, "m3name");
            return (Criteria) this;
        }

        public Criteria andM3nameNotEqualTo(String value) {
            addCriterion("m3name <>", value, "m3name");
            return (Criteria) this;
        }

        public Criteria andM3nameGreaterThan(String value) {
            addCriterion("m3name >", value, "m3name");
            return (Criteria) this;
        }

        public Criteria andM3nameGreaterThanOrEqualTo(String value) {
            addCriterion("m3name >=", value, "m3name");
            return (Criteria) this;
        }

        public Criteria andM3nameLessThan(String value) {
            addCriterion("m3name <", value, "m3name");
            return (Criteria) this;
        }

        public Criteria andM3nameLessThanOrEqualTo(String value) {
            addCriterion("m3name <=", value, "m3name");
            return (Criteria) this;
        }

        public Criteria andM3nameLike(String value) {
            addCriterion("m3name like", value, "m3name");
            return (Criteria) this;
        }

        public Criteria andM3nameNotLike(String value) {
            addCriterion("m3name not like", value, "m3name");
            return (Criteria) this;
        }

        public Criteria andM3nameIn(List<String> values) {
            addCriterion("m3name in", values, "m3name");
            return (Criteria) this;
        }

        public Criteria andM3nameNotIn(List<String> values) {
            addCriterion("m3name not in", values, "m3name");
            return (Criteria) this;
        }

        public Criteria andM3nameBetween(String value1, String value2) {
            addCriterion("m3name between", value1, value2, "m3name");
            return (Criteria) this;
        }

        public Criteria andM3nameNotBetween(String value1, String value2) {
            addCriterion("m3name not between", value1, value2, "m3name");
            return (Criteria) this;
        }

        public Criteria andM3wordpressIsNull() {
            addCriterion("m3wordpress is null");
            return (Criteria) this;
        }

        public Criteria andM3wordpressIsNotNull() {
            addCriterion("m3wordpress is not null");
            return (Criteria) this;
        }

        public Criteria andM3wordpressEqualTo(String value) {
            addCriterion("m3wordpress =", value, "m3wordpress");
            return (Criteria) this;
        }

        public Criteria andM3wordpressNotEqualTo(String value) {
            addCriterion("m3wordpress <>", value, "m3wordpress");
            return (Criteria) this;
        }

        public Criteria andM3wordpressGreaterThan(String value) {
            addCriterion("m3wordpress >", value, "m3wordpress");
            return (Criteria) this;
        }

        public Criteria andM3wordpressGreaterThanOrEqualTo(String value) {
            addCriterion("m3wordpress >=", value, "m3wordpress");
            return (Criteria) this;
        }

        public Criteria andM3wordpressLessThan(String value) {
            addCriterion("m3wordpress <", value, "m3wordpress");
            return (Criteria) this;
        }

        public Criteria andM3wordpressLessThanOrEqualTo(String value) {
            addCriterion("m3wordpress <=", value, "m3wordpress");
            return (Criteria) this;
        }

        public Criteria andM3wordpressLike(String value) {
            addCriterion("m3wordpress like", value, "m3wordpress");
            return (Criteria) this;
        }

        public Criteria andM3wordpressNotLike(String value) {
            addCriterion("m3wordpress not like", value, "m3wordpress");
            return (Criteria) this;
        }

        public Criteria andM3wordpressIn(List<String> values) {
            addCriterion("m3wordpress in", values, "m3wordpress");
            return (Criteria) this;
        }

        public Criteria andM3wordpressNotIn(List<String> values) {
            addCriterion("m3wordpress not in", values, "m3wordpress");
            return (Criteria) this;
        }

        public Criteria andM3wordpressBetween(String value1, String value2) {
            addCriterion("m3wordpress between", value1, value2, "m3wordpress");
            return (Criteria) this;
        }

        public Criteria andM3wordpressNotBetween(String value1, String value2) {
            addCriterion("m3wordpress not between", value1, value2, "m3wordpress");
            return (Criteria) this;
        }

        public Criteria andM3earningIsNull() {
            addCriterion("m3Earning is null");
            return (Criteria) this;
        }

        public Criteria andM3earningIsNotNull() {
            addCriterion("m3Earning is not null");
            return (Criteria) this;
        }

        public Criteria andM3earningEqualTo(String value) {
            addCriterion("m3Earning =", value, "m3earning");
            return (Criteria) this;
        }

        public Criteria andM3earningNotEqualTo(String value) {
            addCriterion("m3Earning <>", value, "m3earning");
            return (Criteria) this;
        }

        public Criteria andM3earningGreaterThan(String value) {
            addCriterion("m3Earning >", value, "m3earning");
            return (Criteria) this;
        }

        public Criteria andM3earningGreaterThanOrEqualTo(String value) {
            addCriterion("m3Earning >=", value, "m3earning");
            return (Criteria) this;
        }

        public Criteria andM3earningLessThan(String value) {
            addCriterion("m3Earning <", value, "m3earning");
            return (Criteria) this;
        }

        public Criteria andM3earningLessThanOrEqualTo(String value) {
            addCriterion("m3Earning <=", value, "m3earning");
            return (Criteria) this;
        }

        public Criteria andM3earningLike(String value) {
            addCriterion("m3Earning like", value, "m3earning");
            return (Criteria) this;
        }

        public Criteria andM3earningNotLike(String value) {
            addCriterion("m3Earning not like", value, "m3earning");
            return (Criteria) this;
        }

        public Criteria andM3earningIn(List<String> values) {
            addCriterion("m3Earning in", values, "m3earning");
            return (Criteria) this;
        }

        public Criteria andM3earningNotIn(List<String> values) {
            addCriterion("m3Earning not in", values, "m3earning");
            return (Criteria) this;
        }

        public Criteria andM3earningBetween(String value1, String value2) {
            addCriterion("m3Earning between", value1, value2, "m3earning");
            return (Criteria) this;
        }

        public Criteria andM3earningNotBetween(String value1, String value2) {
            addCriterion("m3Earning not between", value1, value2, "m3earning");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewIsNull() {
            addCriterion("counselorReview is null");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewIsNotNull() {
            addCriterion("counselorReview is not null");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewEqualTo(Integer value) {
            addCriterion("counselorReview =", value, "counselorreview");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewNotEqualTo(Integer value) {
            addCriterion("counselorReview <>", value, "counselorreview");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewGreaterThan(Integer value) {
            addCriterion("counselorReview >", value, "counselorreview");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewGreaterThanOrEqualTo(Integer value) {
            addCriterion("counselorReview >=", value, "counselorreview");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewLessThan(Integer value) {
            addCriterion("counselorReview <", value, "counselorreview");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewLessThanOrEqualTo(Integer value) {
            addCriterion("counselorReview <=", value, "counselorreview");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewIn(List<Integer> values) {
            addCriterion("counselorReview in", values, "counselorreview");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewNotIn(List<Integer> values) {
            addCriterion("counselorReview not in", values, "counselorreview");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewBetween(Integer value1, Integer value2) {
            addCriterion("counselorReview between", value1, value2, "counselorreview");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewNotBetween(Integer value1, Integer value2) {
            addCriterion("counselorReview not between", value1, value2, "counselorreview");
            return (Criteria) this;
        }

        public Criteria andAdminIsNull() {
            addCriterion("admin is null");
            return (Criteria) this;
        }

        public Criteria andAdminIsNotNull() {
            addCriterion("admin is not null");
            return (Criteria) this;
        }

        public Criteria andAdminEqualTo(Integer value) {
            addCriterion("admin =", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotEqualTo(Integer value) {
            addCriterion("admin <>", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminGreaterThan(Integer value) {
            addCriterion("admin >", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin >=", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminLessThan(Integer value) {
            addCriterion("admin <", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminLessThanOrEqualTo(Integer value) {
            addCriterion("admin <=", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminIn(List<Integer> values) {
            addCriterion("admin in", values, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotIn(List<Integer> values) {
            addCriterion("admin not in", values, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminBetween(Integer value1, Integer value2) {
            addCriterion("admin between", value1, value2, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotBetween(Integer value1, Integer value2) {
            addCriterion("admin not between", value1, value2, "admin");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeIsNull() {
            addCriterion("applicationTime is null");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeIsNotNull() {
            addCriterion("applicationTime is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeEqualTo(Date value) {
            addCriterionForJDBCDate("applicationTime =", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("applicationTime <>", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("applicationTime >", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("applicationTime >=", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeLessThan(Date value) {
            addCriterionForJDBCDate("applicationTime <", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("applicationTime <=", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeIn(List<Date> values) {
            addCriterionForJDBCDate("applicationTime in", values, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("applicationTime not in", values, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("applicationTime between", value1, value2, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("applicationTime not between", value1, value2, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewremarksIsNull() {
            addCriterion("counselorReviewRemarks is null");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewremarksIsNotNull() {
            addCriterion("counselorReviewRemarks is not null");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewremarksEqualTo(String value) {
            addCriterion("counselorReviewRemarks =", value, "counselorreviewremarks");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewremarksNotEqualTo(String value) {
            addCriterion("counselorReviewRemarks <>", value, "counselorreviewremarks");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewremarksGreaterThan(String value) {
            addCriterion("counselorReviewRemarks >", value, "counselorreviewremarks");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewremarksGreaterThanOrEqualTo(String value) {
            addCriterion("counselorReviewRemarks >=", value, "counselorreviewremarks");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewremarksLessThan(String value) {
            addCriterion("counselorReviewRemarks <", value, "counselorreviewremarks");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewremarksLessThanOrEqualTo(String value) {
            addCriterion("counselorReviewRemarks <=", value, "counselorreviewremarks");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewremarksLike(String value) {
            addCriterion("counselorReviewRemarks like", value, "counselorreviewremarks");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewremarksNotLike(String value) {
            addCriterion("counselorReviewRemarks not like", value, "counselorreviewremarks");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewremarksIn(List<String> values) {
            addCriterion("counselorReviewRemarks in", values, "counselorreviewremarks");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewremarksNotIn(List<String> values) {
            addCriterion("counselorReviewRemarks not in", values, "counselorreviewremarks");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewremarksBetween(String value1, String value2) {
            addCriterion("counselorReviewRemarks between", value1, value2, "counselorreviewremarks");
            return (Criteria) this;
        }

        public Criteria andCounselorreviewremarksNotBetween(String value1, String value2) {
            addCriterion("counselorReviewRemarks not between", value1, value2, "counselorreviewremarks");
            return (Criteria) this;
        }

        public Criteria andAdminremarksIsNull() {
            addCriterion("adminRemarks is null");
            return (Criteria) this;
        }

        public Criteria andAdminremarksIsNotNull() {
            addCriterion("adminRemarks is not null");
            return (Criteria) this;
        }

        public Criteria andAdminremarksEqualTo(String value) {
            addCriterion("adminRemarks =", value, "adminremarks");
            return (Criteria) this;
        }

        public Criteria andAdminremarksNotEqualTo(String value) {
            addCriterion("adminRemarks <>", value, "adminremarks");
            return (Criteria) this;
        }

        public Criteria andAdminremarksGreaterThan(String value) {
            addCriterion("adminRemarks >", value, "adminremarks");
            return (Criteria) this;
        }

        public Criteria andAdminremarksGreaterThanOrEqualTo(String value) {
            addCriterion("adminRemarks >=", value, "adminremarks");
            return (Criteria) this;
        }

        public Criteria andAdminremarksLessThan(String value) {
            addCriterion("adminRemarks <", value, "adminremarks");
            return (Criteria) this;
        }

        public Criteria andAdminremarksLessThanOrEqualTo(String value) {
            addCriterion("adminRemarks <=", value, "adminremarks");
            return (Criteria) this;
        }

        public Criteria andAdminremarksLike(String value) {
            addCriterion("adminRemarks like", value, "adminremarks");
            return (Criteria) this;
        }

        public Criteria andAdminremarksNotLike(String value) {
            addCriterion("adminRemarks not like", value, "adminremarks");
            return (Criteria) this;
        }

        public Criteria andAdminremarksIn(List<String> values) {
            addCriterion("adminRemarks in", values, "adminremarks");
            return (Criteria) this;
        }

        public Criteria andAdminremarksNotIn(List<String> values) {
            addCriterion("adminRemarks not in", values, "adminremarks");
            return (Criteria) this;
        }

        public Criteria andAdminremarksBetween(String value1, String value2) {
            addCriterion("adminRemarks between", value1, value2, "adminremarks");
            return (Criteria) this;
        }

        public Criteria andAdminremarksNotBetween(String value1, String value2) {
            addCriterion("adminRemarks not between", value1, value2, "adminremarks");
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