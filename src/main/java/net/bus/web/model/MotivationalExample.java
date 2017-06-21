package net.bus.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MotivationalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MotivationalExample() {
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
            addCriterion("idCard is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNotNull() {
            addCriterion("idCard is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardEqualTo(String value) {
            addCriterion("idCard =", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotEqualTo(String value) {
            addCriterion("idCard <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThan(String value) {
            addCriterion("idCard >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("idCard >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThan(String value) {
            addCriterion("idCard <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThanOrEqualTo(String value) {
            addCriterion("idCard <=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLike(String value) {
            addCriterion("idCard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLike(String value) {
            addCriterion("idCard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardIn(List<String> values) {
            addCriterion("idCard in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotIn(List<String> values) {
            addCriterion("idCard not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("idCard between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("idCard not between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andRankingIsNull() {
            addCriterion("ranking is null");
            return (Criteria) this;
        }

        public Criteria andRankingIsNotNull() {
            addCriterion("ranking is not null");
            return (Criteria) this;
        }

        public Criteria andRankingEqualTo(Integer value) {
            addCriterion("ranking =", value, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingNotEqualTo(Integer value) {
            addCriterion("ranking <>", value, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingGreaterThan(Integer value) {
            addCriterion("ranking >", value, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingGreaterThanOrEqualTo(Integer value) {
            addCriterion("ranking >=", value, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingLessThan(Integer value) {
            addCriterion("ranking <", value, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingLessThanOrEqualTo(Integer value) {
            addCriterion("ranking <=", value, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingIn(List<Integer> values) {
            addCriterion("ranking in", values, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingNotIn(List<Integer> values) {
            addCriterion("ranking not in", values, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingBetween(Integer value1, Integer value2) {
            addCriterion("ranking between", value1, value2, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingNotBetween(Integer value1, Integer value2) {
            addCriterion("ranking not between", value1, value2, "ranking");
            return (Criteria) this;
        }

        public Criteria andTnumberIsNull() {
            addCriterion("tnumber is null");
            return (Criteria) this;
        }

        public Criteria andTnumberIsNotNull() {
            addCriterion("tnumber is not null");
            return (Criteria) this;
        }

        public Criteria andTnumberEqualTo(Integer value) {
            addCriterion("tnumber =", value, "tnumber");
            return (Criteria) this;
        }

        public Criteria andTnumberNotEqualTo(Integer value) {
            addCriterion("tnumber <>", value, "tnumber");
            return (Criteria) this;
        }

        public Criteria andTnumberGreaterThan(Integer value) {
            addCriterion("tnumber >", value, "tnumber");
            return (Criteria) this;
        }

        public Criteria andTnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("tnumber >=", value, "tnumber");
            return (Criteria) this;
        }

        public Criteria andTnumberLessThan(Integer value) {
            addCriterion("tnumber <", value, "tnumber");
            return (Criteria) this;
        }

        public Criteria andTnumberLessThanOrEqualTo(Integer value) {
            addCriterion("tnumber <=", value, "tnumber");
            return (Criteria) this;
        }

        public Criteria andTnumberIn(List<Integer> values) {
            addCriterion("tnumber in", values, "tnumber");
            return (Criteria) this;
        }

        public Criteria andTnumberNotIn(List<Integer> values) {
            addCriterion("tnumber not in", values, "tnumber");
            return (Criteria) this;
        }

        public Criteria andTnumberBetween(Integer value1, Integer value2) {
            addCriterion("tnumber between", value1, value2, "tnumber");
            return (Criteria) this;
        }

        public Criteria andTnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("tnumber not between", value1, value2, "tnumber");
            return (Criteria) this;
        }

        public Criteria andPopulationcountIsNull() {
            addCriterion("populationCount is null");
            return (Criteria) this;
        }

        public Criteria andPopulationcountIsNotNull() {
            addCriterion("populationCount is not null");
            return (Criteria) this;
        }

        public Criteria andPopulationcountEqualTo(String value) {
            addCriterion("populationCount =", value, "populationcount");
            return (Criteria) this;
        }

        public Criteria andPopulationcountNotEqualTo(String value) {
            addCriterion("populationCount <>", value, "populationcount");
            return (Criteria) this;
        }

        public Criteria andPopulationcountGreaterThan(String value) {
            addCriterion("populationCount >", value, "populationcount");
            return (Criteria) this;
        }

        public Criteria andPopulationcountGreaterThanOrEqualTo(String value) {
            addCriterion("populationCount >=", value, "populationcount");
            return (Criteria) this;
        }

        public Criteria andPopulationcountLessThan(String value) {
            addCriterion("populationCount <", value, "populationcount");
            return (Criteria) this;
        }

        public Criteria andPopulationcountLessThanOrEqualTo(String value) {
            addCriterion("populationCount <=", value, "populationcount");
            return (Criteria) this;
        }

        public Criteria andPopulationcountLike(String value) {
            addCriterion("populationCount like", value, "populationcount");
            return (Criteria) this;
        }

        public Criteria andPopulationcountNotLike(String value) {
            addCriterion("populationCount not like", value, "populationcount");
            return (Criteria) this;
        }

        public Criteria andPopulationcountIn(List<String> values) {
            addCriterion("populationCount in", values, "populationcount");
            return (Criteria) this;
        }

        public Criteria andPopulationcountNotIn(List<String> values) {
            addCriterion("populationCount not in", values, "populationcount");
            return (Criteria) this;
        }

        public Criteria andPopulationcountBetween(String value1, String value2) {
            addCriterion("populationCount between", value1, value2, "populationcount");
            return (Criteria) this;
        }

        public Criteria andPopulationcountNotBetween(String value1, String value2) {
            addCriterion("populationCount not between", value1, value2, "populationcount");
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

        public Criteria andFamilyincomeEqualTo(String value) {
            addCriterion("familyIncome =", value, "familyincome");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeNotEqualTo(String value) {
            addCriterion("familyIncome <>", value, "familyincome");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeGreaterThan(String value) {
            addCriterion("familyIncome >", value, "familyincome");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeGreaterThanOrEqualTo(String value) {
            addCriterion("familyIncome >=", value, "familyincome");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeLessThan(String value) {
            addCriterion("familyIncome <", value, "familyincome");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeLessThanOrEqualTo(String value) {
            addCriterion("familyIncome <=", value, "familyincome");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeLike(String value) {
            addCriterion("familyIncome like", value, "familyincome");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeNotLike(String value) {
            addCriterion("familyIncome not like", value, "familyincome");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeIn(List<String> values) {
            addCriterion("familyIncome in", values, "familyincome");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeNotIn(List<String> values) {
            addCriterion("familyIncome not in", values, "familyincome");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeBetween(String value1, String value2) {
            addCriterion("familyIncome between", value1, value2, "familyincome");
            return (Criteria) this;
        }

        public Criteria andFamilyincomeNotBetween(String value1, String value2) {
            addCriterion("familyIncome not between", value1, value2, "familyincome");
            return (Criteria) this;
        }

        public Criteria andMonthlyincomeIsNull() {
            addCriterion("monthlyIncome is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyincomeIsNotNull() {
            addCriterion("monthlyIncome is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyincomeEqualTo(String value) {
            addCriterion("monthlyIncome =", value, "monthlyincome");
            return (Criteria) this;
        }

        public Criteria andMonthlyincomeNotEqualTo(String value) {
            addCriterion("monthlyIncome <>", value, "monthlyincome");
            return (Criteria) this;
        }

        public Criteria andMonthlyincomeGreaterThan(String value) {
            addCriterion("monthlyIncome >", value, "monthlyincome");
            return (Criteria) this;
        }

        public Criteria andMonthlyincomeGreaterThanOrEqualTo(String value) {
            addCriterion("monthlyIncome >=", value, "monthlyincome");
            return (Criteria) this;
        }

        public Criteria andMonthlyincomeLessThan(String value) {
            addCriterion("monthlyIncome <", value, "monthlyincome");
            return (Criteria) this;
        }

        public Criteria andMonthlyincomeLessThanOrEqualTo(String value) {
            addCriterion("monthlyIncome <=", value, "monthlyincome");
            return (Criteria) this;
        }

        public Criteria andMonthlyincomeLike(String value) {
            addCriterion("monthlyIncome like", value, "monthlyincome");
            return (Criteria) this;
        }

        public Criteria andMonthlyincomeNotLike(String value) {
            addCriterion("monthlyIncome not like", value, "monthlyincome");
            return (Criteria) this;
        }

        public Criteria andMonthlyincomeIn(List<String> values) {
            addCriterion("monthlyIncome in", values, "monthlyincome");
            return (Criteria) this;
        }

        public Criteria andMonthlyincomeNotIn(List<String> values) {
            addCriterion("monthlyIncome not in", values, "monthlyincome");
            return (Criteria) this;
        }

        public Criteria andMonthlyincomeBetween(String value1, String value2) {
            addCriterion("monthlyIncome between", value1, value2, "monthlyincome");
            return (Criteria) this;
        }

        public Criteria andMonthlyincomeNotBetween(String value1, String value2) {
            addCriterion("monthlyIncome not between", value1, value2, "monthlyincome");
            return (Criteria) this;
        }

        public Criteria andRevenuesourceIsNull() {
            addCriterion("revenueSource is null");
            return (Criteria) this;
        }

        public Criteria andRevenuesourceIsNotNull() {
            addCriterion("revenueSource is not null");
            return (Criteria) this;
        }

        public Criteria andRevenuesourceEqualTo(String value) {
            addCriterion("revenueSource =", value, "revenuesource");
            return (Criteria) this;
        }

        public Criteria andRevenuesourceNotEqualTo(String value) {
            addCriterion("revenueSource <>", value, "revenuesource");
            return (Criteria) this;
        }

        public Criteria andRevenuesourceGreaterThan(String value) {
            addCriterion("revenueSource >", value, "revenuesource");
            return (Criteria) this;
        }

        public Criteria andRevenuesourceGreaterThanOrEqualTo(String value) {
            addCriterion("revenueSource >=", value, "revenuesource");
            return (Criteria) this;
        }

        public Criteria andRevenuesourceLessThan(String value) {
            addCriterion("revenueSource <", value, "revenuesource");
            return (Criteria) this;
        }

        public Criteria andRevenuesourceLessThanOrEqualTo(String value) {
            addCriterion("revenueSource <=", value, "revenuesource");
            return (Criteria) this;
        }

        public Criteria andRevenuesourceLike(String value) {
            addCriterion("revenueSource like", value, "revenuesource");
            return (Criteria) this;
        }

        public Criteria andRevenuesourceNotLike(String value) {
            addCriterion("revenueSource not like", value, "revenuesource");
            return (Criteria) this;
        }

        public Criteria andRevenuesourceIn(List<String> values) {
            addCriterion("revenueSource in", values, "revenuesource");
            return (Criteria) this;
        }

        public Criteria andRevenuesourceNotIn(List<String> values) {
            addCriterion("revenueSource not in", values, "revenuesource");
            return (Criteria) this;
        }

        public Criteria andRevenuesourceBetween(String value1, String value2) {
            addCriterion("revenueSource between", value1, value2, "revenuesource");
            return (Criteria) this;
        }

        public Criteria andRevenuesourceNotBetween(String value1, String value2) {
            addCriterion("revenueSource not between", value1, value2, "revenuesource");
            return (Criteria) this;
        }

        public Criteria andPoorgradesIsNull() {
            addCriterion("poorGrades is null");
            return (Criteria) this;
        }

        public Criteria andPoorgradesIsNotNull() {
            addCriterion("poorGrades is not null");
            return (Criteria) this;
        }

        public Criteria andPoorgradesEqualTo(String value) {
            addCriterion("poorGrades =", value, "poorgrades");
            return (Criteria) this;
        }

        public Criteria andPoorgradesNotEqualTo(String value) {
            addCriterion("poorGrades <>", value, "poorgrades");
            return (Criteria) this;
        }

        public Criteria andPoorgradesGreaterThan(String value) {
            addCriterion("poorGrades >", value, "poorgrades");
            return (Criteria) this;
        }

        public Criteria andPoorgradesGreaterThanOrEqualTo(String value) {
            addCriterion("poorGrades >=", value, "poorgrades");
            return (Criteria) this;
        }

        public Criteria andPoorgradesLessThan(String value) {
            addCriterion("poorGrades <", value, "poorgrades");
            return (Criteria) this;
        }

        public Criteria andPoorgradesLessThanOrEqualTo(String value) {
            addCriterion("poorGrades <=", value, "poorgrades");
            return (Criteria) this;
        }

        public Criteria andPoorgradesLike(String value) {
            addCriterion("poorGrades like", value, "poorgrades");
            return (Criteria) this;
        }

        public Criteria andPoorgradesNotLike(String value) {
            addCriterion("poorGrades not like", value, "poorgrades");
            return (Criteria) this;
        }

        public Criteria andPoorgradesIn(List<String> values) {
            addCriterion("poorGrades in", values, "poorgrades");
            return (Criteria) this;
        }

        public Criteria andPoorgradesNotIn(List<String> values) {
            addCriterion("poorGrades not in", values, "poorgrades");
            return (Criteria) this;
        }

        public Criteria andPoorgradesBetween(String value1, String value2) {
            addCriterion("poorGrades between", value1, value2, "poorgrades");
            return (Criteria) this;
        }

        public Criteria andPoorgradesNotBetween(String value1, String value2) {
            addCriterion("poorGrades not between", value1, value2, "poorgrades");
            return (Criteria) this;
        }

        public Criteria andAmountedIsNull() {
            addCriterion("amounted is null");
            return (Criteria) this;
        }

        public Criteria andAmountedIsNotNull() {
            addCriterion("amounted is not null");
            return (Criteria) this;
        }

        public Criteria andAmountedEqualTo(String value) {
            addCriterion("amounted =", value, "amounted");
            return (Criteria) this;
        }

        public Criteria andAmountedNotEqualTo(String value) {
            addCriterion("amounted <>", value, "amounted");
            return (Criteria) this;
        }

        public Criteria andAmountedGreaterThan(String value) {
            addCriterion("amounted >", value, "amounted");
            return (Criteria) this;
        }

        public Criteria andAmountedGreaterThanOrEqualTo(String value) {
            addCriterion("amounted >=", value, "amounted");
            return (Criteria) this;
        }

        public Criteria andAmountedLessThan(String value) {
            addCriterion("amounted <", value, "amounted");
            return (Criteria) this;
        }

        public Criteria andAmountedLessThanOrEqualTo(String value) {
            addCriterion("amounted <=", value, "amounted");
            return (Criteria) this;
        }

        public Criteria andAmountedLike(String value) {
            addCriterion("amounted like", value, "amounted");
            return (Criteria) this;
        }

        public Criteria andAmountedNotLike(String value) {
            addCriterion("amounted not like", value, "amounted");
            return (Criteria) this;
        }

        public Criteria andAmountedIn(List<String> values) {
            addCriterion("amounted in", values, "amounted");
            return (Criteria) this;
        }

        public Criteria andAmountedNotIn(List<String> values) {
            addCriterion("amounted not in", values, "amounted");
            return (Criteria) this;
        }

        public Criteria andAmountedBetween(String value1, String value2) {
            addCriterion("amounted between", value1, value2, "amounted");
            return (Criteria) this;
        }

        public Criteria andAmountedNotBetween(String value1, String value2) {
            addCriterion("amounted not between", value1, value2, "amounted");
            return (Criteria) this;
        }

        public Criteria andFundedpurposeIsNull() {
            addCriterion("fundedPurpose is null");
            return (Criteria) this;
        }

        public Criteria andFundedpurposeIsNotNull() {
            addCriterion("fundedPurpose is not null");
            return (Criteria) this;
        }

        public Criteria andFundedpurposeEqualTo(String value) {
            addCriterion("fundedPurpose =", value, "fundedpurpose");
            return (Criteria) this;
        }

        public Criteria andFundedpurposeNotEqualTo(String value) {
            addCriterion("fundedPurpose <>", value, "fundedpurpose");
            return (Criteria) this;
        }

        public Criteria andFundedpurposeGreaterThan(String value) {
            addCriterion("fundedPurpose >", value, "fundedpurpose");
            return (Criteria) this;
        }

        public Criteria andFundedpurposeGreaterThanOrEqualTo(String value) {
            addCriterion("fundedPurpose >=", value, "fundedpurpose");
            return (Criteria) this;
        }

        public Criteria andFundedpurposeLessThan(String value) {
            addCriterion("fundedPurpose <", value, "fundedpurpose");
            return (Criteria) this;
        }

        public Criteria andFundedpurposeLessThanOrEqualTo(String value) {
            addCriterion("fundedPurpose <=", value, "fundedpurpose");
            return (Criteria) this;
        }

        public Criteria andFundedpurposeLike(String value) {
            addCriterion("fundedPurpose like", value, "fundedpurpose");
            return (Criteria) this;
        }

        public Criteria andFundedpurposeNotLike(String value) {
            addCriterion("fundedPurpose not like", value, "fundedpurpose");
            return (Criteria) this;
        }

        public Criteria andFundedpurposeIn(List<String> values) {
            addCriterion("fundedPurpose in", values, "fundedpurpose");
            return (Criteria) this;
        }

        public Criteria andFundedpurposeNotIn(List<String> values) {
            addCriterion("fundedPurpose not in", values, "fundedpurpose");
            return (Criteria) this;
        }

        public Criteria andFundedpurposeBetween(String value1, String value2) {
            addCriterion("fundedPurpose between", value1, value2, "fundedpurpose");
            return (Criteria) this;
        }

        public Criteria andFundedpurposeNotBetween(String value1, String value2) {
            addCriterion("fundedPurpose not between", value1, value2, "fundedpurpose");
            return (Criteria) this;
        }

        public Criteria andFundpurposeIsNull() {
            addCriterion("fundPurpose is null");
            return (Criteria) this;
        }

        public Criteria andFundpurposeIsNotNull() {
            addCriterion("fundPurpose is not null");
            return (Criteria) this;
        }

        public Criteria andFundpurposeEqualTo(String value) {
            addCriterion("fundPurpose =", value, "fundpurpose");
            return (Criteria) this;
        }

        public Criteria andFundpurposeNotEqualTo(String value) {
            addCriterion("fundPurpose <>", value, "fundpurpose");
            return (Criteria) this;
        }

        public Criteria andFundpurposeGreaterThan(String value) {
            addCriterion("fundPurpose >", value, "fundpurpose");
            return (Criteria) this;
        }

        public Criteria andFundpurposeGreaterThanOrEqualTo(String value) {
            addCriterion("fundPurpose >=", value, "fundpurpose");
            return (Criteria) this;
        }

        public Criteria andFundpurposeLessThan(String value) {
            addCriterion("fundPurpose <", value, "fundpurpose");
            return (Criteria) this;
        }

        public Criteria andFundpurposeLessThanOrEqualTo(String value) {
            addCriterion("fundPurpose <=", value, "fundpurpose");
            return (Criteria) this;
        }

        public Criteria andFundpurposeLike(String value) {
            addCriterion("fundPurpose like", value, "fundpurpose");
            return (Criteria) this;
        }

        public Criteria andFundpurposeNotLike(String value) {
            addCriterion("fundPurpose not like", value, "fundpurpose");
            return (Criteria) this;
        }

        public Criteria andFundpurposeIn(List<String> values) {
            addCriterion("fundPurpose in", values, "fundpurpose");
            return (Criteria) this;
        }

        public Criteria andFundpurposeNotIn(List<String> values) {
            addCriterion("fundPurpose not in", values, "fundpurpose");
            return (Criteria) this;
        }

        public Criteria andFundpurposeBetween(String value1, String value2) {
            addCriterion("fundPurpose between", value1, value2, "fundpurpose");
            return (Criteria) this;
        }

        public Criteria andFundpurposeNotBetween(String value1, String value2) {
            addCriterion("fundPurpose not between", value1, value2, "fundpurpose");
            return (Criteria) this;
        }

        public Criteria andBankaccountIsNull() {
            addCriterion("bankAccount is null");
            return (Criteria) this;
        }

        public Criteria andBankaccountIsNotNull() {
            addCriterion("bankAccount is not null");
            return (Criteria) this;
        }

        public Criteria andBankaccountEqualTo(String value) {
            addCriterion("bankAccount =", value, "bankaccount");
            return (Criteria) this;
        }

        public Criteria andBankaccountNotEqualTo(String value) {
            addCriterion("bankAccount <>", value, "bankaccount");
            return (Criteria) this;
        }

        public Criteria andBankaccountGreaterThan(String value) {
            addCriterion("bankAccount >", value, "bankaccount");
            return (Criteria) this;
        }

        public Criteria andBankaccountGreaterThanOrEqualTo(String value) {
            addCriterion("bankAccount >=", value, "bankaccount");
            return (Criteria) this;
        }

        public Criteria andBankaccountLessThan(String value) {
            addCriterion("bankAccount <", value, "bankaccount");
            return (Criteria) this;
        }

        public Criteria andBankaccountLessThanOrEqualTo(String value) {
            addCriterion("bankAccount <=", value, "bankaccount");
            return (Criteria) this;
        }

        public Criteria andBankaccountLike(String value) {
            addCriterion("bankAccount like", value, "bankaccount");
            return (Criteria) this;
        }

        public Criteria andBankaccountNotLike(String value) {
            addCriterion("bankAccount not like", value, "bankaccount");
            return (Criteria) this;
        }

        public Criteria andBankaccountIn(List<String> values) {
            addCriterion("bankAccount in", values, "bankaccount");
            return (Criteria) this;
        }

        public Criteria andBankaccountNotIn(List<String> values) {
            addCriterion("bankAccount not in", values, "bankaccount");
            return (Criteria) this;
        }

        public Criteria andBankaccountBetween(String value1, String value2) {
            addCriterion("bankAccount between", value1, value2, "bankaccount");
            return (Criteria) this;
        }

        public Criteria andBankaccountNotBetween(String value1, String value2) {
            addCriterion("bankAccount not between", value1, value2, "bankaccount");
            return (Criteria) this;
        }

        public Criteria andApplicationreasonsIsNull() {
            addCriterion("applicationReasons is null");
            return (Criteria) this;
        }

        public Criteria andApplicationreasonsIsNotNull() {
            addCriterion("applicationReasons is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationreasonsEqualTo(String value) {
            addCriterion("applicationReasons =", value, "applicationreasons");
            return (Criteria) this;
        }

        public Criteria andApplicationreasonsNotEqualTo(String value) {
            addCriterion("applicationReasons <>", value, "applicationreasons");
            return (Criteria) this;
        }

        public Criteria andApplicationreasonsGreaterThan(String value) {
            addCriterion("applicationReasons >", value, "applicationreasons");
            return (Criteria) this;
        }

        public Criteria andApplicationreasonsGreaterThanOrEqualTo(String value) {
            addCriterion("applicationReasons >=", value, "applicationreasons");
            return (Criteria) this;
        }

        public Criteria andApplicationreasonsLessThan(String value) {
            addCriterion("applicationReasons <", value, "applicationreasons");
            return (Criteria) this;
        }

        public Criteria andApplicationreasonsLessThanOrEqualTo(String value) {
            addCriterion("applicationReasons <=", value, "applicationreasons");
            return (Criteria) this;
        }

        public Criteria andApplicationreasonsLike(String value) {
            addCriterion("applicationReasons like", value, "applicationreasons");
            return (Criteria) this;
        }

        public Criteria andApplicationreasonsNotLike(String value) {
            addCriterion("applicationReasons not like", value, "applicationreasons");
            return (Criteria) this;
        }

        public Criteria andApplicationreasonsIn(List<String> values) {
            addCriterion("applicationReasons in", values, "applicationreasons");
            return (Criteria) this;
        }

        public Criteria andApplicationreasonsNotIn(List<String> values) {
            addCriterion("applicationReasons not in", values, "applicationreasons");
            return (Criteria) this;
        }

        public Criteria andApplicationreasonsBetween(String value1, String value2) {
            addCriterion("applicationReasons between", value1, value2, "applicationreasons");
            return (Criteria) this;
        }

        public Criteria andApplicationreasonsNotBetween(String value1, String value2) {
            addCriterion("applicationReasons not between", value1, value2, "applicationreasons");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("Remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("Remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(Date value) {
            addCriterionForJDBCDate("Remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(Date value) {
            addCriterionForJDBCDate("Remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(Date value) {
            addCriterionForJDBCDate("Remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(Date value) {
            addCriterionForJDBCDate("Remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<Date> values) {
            addCriterionForJDBCDate("Remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<Date> values) {
            addCriterionForJDBCDate("Remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Remarks not between", value1, value2, "remarks");
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

        public Criteria andApplicationtimeIsNull() {
            addCriterion("ApplicationTime is null");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeIsNotNull() {
            addCriterion("ApplicationTime is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeEqualTo(Date value) {
            addCriterionForJDBCDate("ApplicationTime =", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ApplicationTime <>", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ApplicationTime >", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ApplicationTime >=", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeLessThan(Date value) {
            addCriterionForJDBCDate("ApplicationTime <", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ApplicationTime <=", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeIn(List<Date> values) {
            addCriterionForJDBCDate("ApplicationTime in", values, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ApplicationTime not in", values, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ApplicationTime between", value1, value2, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ApplicationTime not between", value1, value2, "applicationtime");
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