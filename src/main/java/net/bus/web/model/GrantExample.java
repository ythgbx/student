package net.bus.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class GrantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GrantExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNoIsNull() {
            addCriterion("no is null");
            return (Criteria) this;
        }

        public Criteria andNoIsNotNull() {
            addCriterion("no is not null");
            return (Criteria) this;
        }

        public Criteria andNoEqualTo(Long value) {
            addCriterion("no =", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotEqualTo(Long value) {
            addCriterion("no <>", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThan(Long value) {
            addCriterion("no >", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThanOrEqualTo(Long value) {
            addCriterion("no >=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThan(Long value) {
            addCriterion("no <", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThanOrEqualTo(Long value) {
            addCriterion("no <=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoIn(List<Long> values) {
            addCriterion("no in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotIn(List<Long> values) {
            addCriterion("no not in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoBetween(Long value1, Long value2) {
            addCriterion("no between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotBetween(Long value1, Long value2) {
            addCriterion("no not between", value1, value2, "no");
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

        public Criteria andM1ageIsNull() {
            addCriterion("m1age is null");
            return (Criteria) this;
        }

        public Criteria andM1ageIsNotNull() {
            addCriterion("m1age is not null");
            return (Criteria) this;
        }

        public Criteria andM1ageEqualTo(Integer value) {
            addCriterion("m1age =", value, "m1age");
            return (Criteria) this;
        }

        public Criteria andM1ageNotEqualTo(Integer value) {
            addCriterion("m1age <>", value, "m1age");
            return (Criteria) this;
        }

        public Criteria andM1ageGreaterThan(Integer value) {
            addCriterion("m1age >", value, "m1age");
            return (Criteria) this;
        }

        public Criteria andM1ageGreaterThanOrEqualTo(Integer value) {
            addCriterion("m1age >=", value, "m1age");
            return (Criteria) this;
        }

        public Criteria andM1ageLessThan(Integer value) {
            addCriterion("m1age <", value, "m1age");
            return (Criteria) this;
        }

        public Criteria andM1ageLessThanOrEqualTo(Integer value) {
            addCriterion("m1age <=", value, "m1age");
            return (Criteria) this;
        }

        public Criteria andM1ageIn(List<Integer> values) {
            addCriterion("m1age in", values, "m1age");
            return (Criteria) this;
        }

        public Criteria andM1ageNotIn(List<Integer> values) {
            addCriterion("m1age not in", values, "m1age");
            return (Criteria) this;
        }

        public Criteria andM1ageBetween(Integer value1, Integer value2) {
            addCriterion("m1age between", value1, value2, "m1age");
            return (Criteria) this;
        }

        public Criteria andM1ageNotBetween(Integer value1, Integer value2) {
            addCriterion("m1age not between", value1, value2, "m1age");
            return (Criteria) this;
        }

        public Criteria andM1relationsIsNull() {
            addCriterion("m1Relations is null");
            return (Criteria) this;
        }

        public Criteria andM1relationsIsNotNull() {
            addCriterion("m1Relations is not null");
            return (Criteria) this;
        }

        public Criteria andM1relationsEqualTo(String value) {
            addCriterion("m1Relations =", value, "m1relations");
            return (Criteria) this;
        }

        public Criteria andM1relationsNotEqualTo(String value) {
            addCriterion("m1Relations <>", value, "m1relations");
            return (Criteria) this;
        }

        public Criteria andM1relationsGreaterThan(String value) {
            addCriterion("m1Relations >", value, "m1relations");
            return (Criteria) this;
        }

        public Criteria andM1relationsGreaterThanOrEqualTo(String value) {
            addCriterion("m1Relations >=", value, "m1relations");
            return (Criteria) this;
        }

        public Criteria andM1relationsLessThan(String value) {
            addCriterion("m1Relations <", value, "m1relations");
            return (Criteria) this;
        }

        public Criteria andM1relationsLessThanOrEqualTo(String value) {
            addCriterion("m1Relations <=", value, "m1relations");
            return (Criteria) this;
        }

        public Criteria andM1relationsLike(String value) {
            addCriterion("m1Relations like", value, "m1relations");
            return (Criteria) this;
        }

        public Criteria andM1relationsNotLike(String value) {
            addCriterion("m1Relations not like", value, "m1relations");
            return (Criteria) this;
        }

        public Criteria andM1relationsIn(List<String> values) {
            addCriterion("m1Relations in", values, "m1relations");
            return (Criteria) this;
        }

        public Criteria andM1relationsNotIn(List<String> values) {
            addCriterion("m1Relations not in", values, "m1relations");
            return (Criteria) this;
        }

        public Criteria andM1relationsBetween(String value1, String value2) {
            addCriterion("m1Relations between", value1, value2, "m1relations");
            return (Criteria) this;
        }

        public Criteria andM1relationsNotBetween(String value1, String value2) {
            addCriterion("m1Relations not between", value1, value2, "m1relations");
            return (Criteria) this;
        }

        public Criteria andM1companyIsNull() {
            addCriterion("m1Company is null");
            return (Criteria) this;
        }

        public Criteria andM1companyIsNotNull() {
            addCriterion("m1Company is not null");
            return (Criteria) this;
        }

        public Criteria andM1companyEqualTo(String value) {
            addCriterion("m1Company =", value, "m1company");
            return (Criteria) this;
        }

        public Criteria andM1companyNotEqualTo(String value) {
            addCriterion("m1Company <>", value, "m1company");
            return (Criteria) this;
        }

        public Criteria andM1companyGreaterThan(String value) {
            addCriterion("m1Company >", value, "m1company");
            return (Criteria) this;
        }

        public Criteria andM1companyGreaterThanOrEqualTo(String value) {
            addCriterion("m1Company >=", value, "m1company");
            return (Criteria) this;
        }

        public Criteria andM1companyLessThan(String value) {
            addCriterion("m1Company <", value, "m1company");
            return (Criteria) this;
        }

        public Criteria andM1companyLessThanOrEqualTo(String value) {
            addCriterion("m1Company <=", value, "m1company");
            return (Criteria) this;
        }

        public Criteria andM1companyLike(String value) {
            addCriterion("m1Company like", value, "m1company");
            return (Criteria) this;
        }

        public Criteria andM1companyNotLike(String value) {
            addCriterion("m1Company not like", value, "m1company");
            return (Criteria) this;
        }

        public Criteria andM1companyIn(List<String> values) {
            addCriterion("m1Company in", values, "m1company");
            return (Criteria) this;
        }

        public Criteria andM1companyNotIn(List<String> values) {
            addCriterion("m1Company not in", values, "m1company");
            return (Criteria) this;
        }

        public Criteria andM1companyBetween(String value1, String value2) {
            addCriterion("m1Company between", value1, value2, "m1company");
            return (Criteria) this;
        }

        public Criteria andM1companyNotBetween(String value1, String value2) {
            addCriterion("m1Company not between", value1, value2, "m1company");
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

        public Criteria andM2ageIsNull() {
            addCriterion("m2age is null");
            return (Criteria) this;
        }

        public Criteria andM2ageIsNotNull() {
            addCriterion("m2age is not null");
            return (Criteria) this;
        }

        public Criteria andM2ageEqualTo(Integer value) {
            addCriterion("m2age =", value, "m2age");
            return (Criteria) this;
        }

        public Criteria andM2ageNotEqualTo(Integer value) {
            addCriterion("m2age <>", value, "m2age");
            return (Criteria) this;
        }

        public Criteria andM2ageGreaterThan(Integer value) {
            addCriterion("m2age >", value, "m2age");
            return (Criteria) this;
        }

        public Criteria andM2ageGreaterThanOrEqualTo(Integer value) {
            addCriterion("m2age >=", value, "m2age");
            return (Criteria) this;
        }

        public Criteria andM2ageLessThan(Integer value) {
            addCriterion("m2age <", value, "m2age");
            return (Criteria) this;
        }

        public Criteria andM2ageLessThanOrEqualTo(Integer value) {
            addCriterion("m2age <=", value, "m2age");
            return (Criteria) this;
        }

        public Criteria andM2ageIn(List<Integer> values) {
            addCriterion("m2age in", values, "m2age");
            return (Criteria) this;
        }

        public Criteria andM2ageNotIn(List<Integer> values) {
            addCriterion("m2age not in", values, "m2age");
            return (Criteria) this;
        }

        public Criteria andM2ageBetween(Integer value1, Integer value2) {
            addCriterion("m2age between", value1, value2, "m2age");
            return (Criteria) this;
        }

        public Criteria andM2ageNotBetween(Integer value1, Integer value2) {
            addCriterion("m2age not between", value1, value2, "m2age");
            return (Criteria) this;
        }

        public Criteria andM2relationsIsNull() {
            addCriterion("m2Relations is null");
            return (Criteria) this;
        }

        public Criteria andM2relationsIsNotNull() {
            addCriterion("m2Relations is not null");
            return (Criteria) this;
        }

        public Criteria andM2relationsEqualTo(String value) {
            addCriterion("m2Relations =", value, "m2relations");
            return (Criteria) this;
        }

        public Criteria andM2relationsNotEqualTo(String value) {
            addCriterion("m2Relations <>", value, "m2relations");
            return (Criteria) this;
        }

        public Criteria andM2relationsGreaterThan(String value) {
            addCriterion("m2Relations >", value, "m2relations");
            return (Criteria) this;
        }

        public Criteria andM2relationsGreaterThanOrEqualTo(String value) {
            addCriterion("m2Relations >=", value, "m2relations");
            return (Criteria) this;
        }

        public Criteria andM2relationsLessThan(String value) {
            addCriterion("m2Relations <", value, "m2relations");
            return (Criteria) this;
        }

        public Criteria andM2relationsLessThanOrEqualTo(String value) {
            addCriterion("m2Relations <=", value, "m2relations");
            return (Criteria) this;
        }

        public Criteria andM2relationsLike(String value) {
            addCriterion("m2Relations like", value, "m2relations");
            return (Criteria) this;
        }

        public Criteria andM2relationsNotLike(String value) {
            addCriterion("m2Relations not like", value, "m2relations");
            return (Criteria) this;
        }

        public Criteria andM2relationsIn(List<String> values) {
            addCriterion("m2Relations in", values, "m2relations");
            return (Criteria) this;
        }

        public Criteria andM2relationsNotIn(List<String> values) {
            addCriterion("m2Relations not in", values, "m2relations");
            return (Criteria) this;
        }

        public Criteria andM2relationsBetween(String value1, String value2) {
            addCriterion("m2Relations between", value1, value2, "m2relations");
            return (Criteria) this;
        }

        public Criteria andM2relationsNotBetween(String value1, String value2) {
            addCriterion("m2Relations not between", value1, value2, "m2relations");
            return (Criteria) this;
        }

        public Criteria andM2companyIsNull() {
            addCriterion("m2Company is null");
            return (Criteria) this;
        }

        public Criteria andM2companyIsNotNull() {
            addCriterion("m2Company is not null");
            return (Criteria) this;
        }

        public Criteria andM2companyEqualTo(String value) {
            addCriterion("m2Company =", value, "m2company");
            return (Criteria) this;
        }

        public Criteria andM2companyNotEqualTo(String value) {
            addCriterion("m2Company <>", value, "m2company");
            return (Criteria) this;
        }

        public Criteria andM2companyGreaterThan(String value) {
            addCriterion("m2Company >", value, "m2company");
            return (Criteria) this;
        }

        public Criteria andM2companyGreaterThanOrEqualTo(String value) {
            addCriterion("m2Company >=", value, "m2company");
            return (Criteria) this;
        }

        public Criteria andM2companyLessThan(String value) {
            addCriterion("m2Company <", value, "m2company");
            return (Criteria) this;
        }

        public Criteria andM2companyLessThanOrEqualTo(String value) {
            addCriterion("m2Company <=", value, "m2company");
            return (Criteria) this;
        }

        public Criteria andM2companyLike(String value) {
            addCriterion("m2Company like", value, "m2company");
            return (Criteria) this;
        }

        public Criteria andM2companyNotLike(String value) {
            addCriterion("m2Company not like", value, "m2company");
            return (Criteria) this;
        }

        public Criteria andM2companyIn(List<String> values) {
            addCriterion("m2Company in", values, "m2company");
            return (Criteria) this;
        }

        public Criteria andM2companyNotIn(List<String> values) {
            addCriterion("m2Company not in", values, "m2company");
            return (Criteria) this;
        }

        public Criteria andM2companyBetween(String value1, String value2) {
            addCriterion("m2Company between", value1, value2, "m2company");
            return (Criteria) this;
        }

        public Criteria andM2companyNotBetween(String value1, String value2) {
            addCriterion("m2Company not between", value1, value2, "m2company");
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

        public Criteria andM3ageIsNull() {
            addCriterion("m3age is null");
            return (Criteria) this;
        }

        public Criteria andM3ageIsNotNull() {
            addCriterion("m3age is not null");
            return (Criteria) this;
        }

        public Criteria andM3ageEqualTo(Integer value) {
            addCriterion("m3age =", value, "m3age");
            return (Criteria) this;
        }

        public Criteria andM3ageNotEqualTo(Integer value) {
            addCriterion("m3age <>", value, "m3age");
            return (Criteria) this;
        }

        public Criteria andM3ageGreaterThan(Integer value) {
            addCriterion("m3age >", value, "m3age");
            return (Criteria) this;
        }

        public Criteria andM3ageGreaterThanOrEqualTo(Integer value) {
            addCriterion("m3age >=", value, "m3age");
            return (Criteria) this;
        }

        public Criteria andM3ageLessThan(Integer value) {
            addCriterion("m3age <", value, "m3age");
            return (Criteria) this;
        }

        public Criteria andM3ageLessThanOrEqualTo(Integer value) {
            addCriterion("m3age <=", value, "m3age");
            return (Criteria) this;
        }

        public Criteria andM3ageIn(List<Integer> values) {
            addCriterion("m3age in", values, "m3age");
            return (Criteria) this;
        }

        public Criteria andM3ageNotIn(List<Integer> values) {
            addCriterion("m3age not in", values, "m3age");
            return (Criteria) this;
        }

        public Criteria andM3ageBetween(Integer value1, Integer value2) {
            addCriterion("m3age between", value1, value2, "m3age");
            return (Criteria) this;
        }

        public Criteria andM3ageNotBetween(Integer value1, Integer value2) {
            addCriterion("m3age not between", value1, value2, "m3age");
            return (Criteria) this;
        }

        public Criteria andM3relationsIsNull() {
            addCriterion("m3Relations is null");
            return (Criteria) this;
        }

        public Criteria andM3relationsIsNotNull() {
            addCriterion("m3Relations is not null");
            return (Criteria) this;
        }

        public Criteria andM3relationsEqualTo(String value) {
            addCriterion("m3Relations =", value, "m3relations");
            return (Criteria) this;
        }

        public Criteria andM3relationsNotEqualTo(String value) {
            addCriterion("m3Relations <>", value, "m3relations");
            return (Criteria) this;
        }

        public Criteria andM3relationsGreaterThan(String value) {
            addCriterion("m3Relations >", value, "m3relations");
            return (Criteria) this;
        }

        public Criteria andM3relationsGreaterThanOrEqualTo(String value) {
            addCriterion("m3Relations >=", value, "m3relations");
            return (Criteria) this;
        }

        public Criteria andM3relationsLessThan(String value) {
            addCriterion("m3Relations <", value, "m3relations");
            return (Criteria) this;
        }

        public Criteria andM3relationsLessThanOrEqualTo(String value) {
            addCriterion("m3Relations <=", value, "m3relations");
            return (Criteria) this;
        }

        public Criteria andM3relationsLike(String value) {
            addCriterion("m3Relations like", value, "m3relations");
            return (Criteria) this;
        }

        public Criteria andM3relationsNotLike(String value) {
            addCriterion("m3Relations not like", value, "m3relations");
            return (Criteria) this;
        }

        public Criteria andM3relationsIn(List<String> values) {
            addCriterion("m3Relations in", values, "m3relations");
            return (Criteria) this;
        }

        public Criteria andM3relationsNotIn(List<String> values) {
            addCriterion("m3Relations not in", values, "m3relations");
            return (Criteria) this;
        }

        public Criteria andM3relationsBetween(String value1, String value2) {
            addCriterion("m3Relations between", value1, value2, "m3relations");
            return (Criteria) this;
        }

        public Criteria andM3relationsNotBetween(String value1, String value2) {
            addCriterion("m3Relations not between", value1, value2, "m3relations");
            return (Criteria) this;
        }

        public Criteria andM3companyIsNull() {
            addCriterion("m3Company is null");
            return (Criteria) this;
        }

        public Criteria andM3companyIsNotNull() {
            addCriterion("m3Company is not null");
            return (Criteria) this;
        }

        public Criteria andM3companyEqualTo(String value) {
            addCriterion("m3Company =", value, "m3company");
            return (Criteria) this;
        }

        public Criteria andM3companyNotEqualTo(String value) {
            addCriterion("m3Company <>", value, "m3company");
            return (Criteria) this;
        }

        public Criteria andM3companyGreaterThan(String value) {
            addCriterion("m3Company >", value, "m3company");
            return (Criteria) this;
        }

        public Criteria andM3companyGreaterThanOrEqualTo(String value) {
            addCriterion("m3Company >=", value, "m3company");
            return (Criteria) this;
        }

        public Criteria andM3companyLessThan(String value) {
            addCriterion("m3Company <", value, "m3company");
            return (Criteria) this;
        }

        public Criteria andM3companyLessThanOrEqualTo(String value) {
            addCriterion("m3Company <=", value, "m3company");
            return (Criteria) this;
        }

        public Criteria andM3companyLike(String value) {
            addCriterion("m3Company like", value, "m3company");
            return (Criteria) this;
        }

        public Criteria andM3companyNotLike(String value) {
            addCriterion("m3Company not like", value, "m3company");
            return (Criteria) this;
        }

        public Criteria andM3companyIn(List<String> values) {
            addCriterion("m3Company in", values, "m3company");
            return (Criteria) this;
        }

        public Criteria andM3companyNotIn(List<String> values) {
            addCriterion("m3Company not in", values, "m3company");
            return (Criteria) this;
        }

        public Criteria andM3companyBetween(String value1, String value2) {
            addCriterion("m3Company between", value1, value2, "m3company");
            return (Criteria) this;
        }

        public Criteria andM3companyNotBetween(String value1, String value2) {
            addCriterion("m3Company not between", value1, value2, "m3company");
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

        public Criteria andMsignIsNull() {
            addCriterion("Msign is null");
            return (Criteria) this;
        }

        public Criteria andMsignIsNotNull() {
            addCriterion("Msign is not null");
            return (Criteria) this;
        }

        public Criteria andMsignEqualTo(String value) {
            addCriterion("Msign =", value, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignNotEqualTo(String value) {
            addCriterion("Msign <>", value, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignGreaterThan(String value) {
            addCriterion("Msign >", value, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignGreaterThanOrEqualTo(String value) {
            addCriterion("Msign >=", value, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignLessThan(String value) {
            addCriterion("Msign <", value, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignLessThanOrEqualTo(String value) {
            addCriterion("Msign <=", value, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignLike(String value) {
            addCriterion("Msign like", value, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignNotLike(String value) {
            addCriterion("Msign not like", value, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignIn(List<String> values) {
            addCriterion("Msign in", values, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignNotIn(List<String> values) {
            addCriterion("Msign not in", values, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignBetween(String value1, String value2) {
            addCriterion("Msign between", value1, value2, "msign");
            return (Criteria) this;
        }

        public Criteria andMsignNotBetween(String value1, String value2) {
            addCriterion("Msign not between", value1, value2, "msign");
            return (Criteria) this;
        }

        public Criteria andMsigndateIsNull() {
            addCriterion("MsignDate is null");
            return (Criteria) this;
        }

        public Criteria andMsigndateIsNotNull() {
            addCriterion("MsignDate is not null");
            return (Criteria) this;
        }

        public Criteria andMsigndateEqualTo(Date value) {
            addCriterionForJDBCDate("MsignDate =", value, "msigndate");
            return (Criteria) this;
        }

        public Criteria andMsigndateNotEqualTo(Date value) {
            addCriterionForJDBCDate("MsignDate <>", value, "msigndate");
            return (Criteria) this;
        }

        public Criteria andMsigndateGreaterThan(Date value) {
            addCriterionForJDBCDate("MsignDate >", value, "msigndate");
            return (Criteria) this;
        }

        public Criteria andMsigndateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("MsignDate >=", value, "msigndate");
            return (Criteria) this;
        }

        public Criteria andMsigndateLessThan(Date value) {
            addCriterionForJDBCDate("MsignDate <", value, "msigndate");
            return (Criteria) this;
        }

        public Criteria andMsigndateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("MsignDate <=", value, "msigndate");
            return (Criteria) this;
        }

        public Criteria andMsigndateIn(List<Date> values) {
            addCriterionForJDBCDate("MsignDate in", values, "msigndate");
            return (Criteria) this;
        }

        public Criteria andMsigndateNotIn(List<Date> values) {
            addCriterionForJDBCDate("MsignDate not in", values, "msigndate");
            return (Criteria) this;
        }

        public Criteria andMsigndateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("MsignDate between", value1, value2, "msigndate");
            return (Criteria) this;
        }

        public Criteria andMsigndateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("MsignDate not between", value1, value2, "msigndate");
            return (Criteria) this;
        }

        public Criteria andDsignIsNull() {
            addCriterion("Dsign is null");
            return (Criteria) this;
        }

        public Criteria andDsignIsNotNull() {
            addCriterion("Dsign is not null");
            return (Criteria) this;
        }

        public Criteria andDsignEqualTo(String value) {
            addCriterion("Dsign =", value, "dsign");
            return (Criteria) this;
        }

        public Criteria andDsignNotEqualTo(String value) {
            addCriterion("Dsign <>", value, "dsign");
            return (Criteria) this;
        }

        public Criteria andDsignGreaterThan(String value) {
            addCriterion("Dsign >", value, "dsign");
            return (Criteria) this;
        }

        public Criteria andDsignGreaterThanOrEqualTo(String value) {
            addCriterion("Dsign >=", value, "dsign");
            return (Criteria) this;
        }

        public Criteria andDsignLessThan(String value) {
            addCriterion("Dsign <", value, "dsign");
            return (Criteria) this;
        }

        public Criteria andDsignLessThanOrEqualTo(String value) {
            addCriterion("Dsign <=", value, "dsign");
            return (Criteria) this;
        }

        public Criteria andDsignLike(String value) {
            addCriterion("Dsign like", value, "dsign");
            return (Criteria) this;
        }

        public Criteria andDsignNotLike(String value) {
            addCriterion("Dsign not like", value, "dsign");
            return (Criteria) this;
        }

        public Criteria andDsignIn(List<String> values) {
            addCriterion("Dsign in", values, "dsign");
            return (Criteria) this;
        }

        public Criteria andDsignNotIn(List<String> values) {
            addCriterion("Dsign not in", values, "dsign");
            return (Criteria) this;
        }

        public Criteria andDsignBetween(String value1, String value2) {
            addCriterion("Dsign between", value1, value2, "dsign");
            return (Criteria) this;
        }

        public Criteria andDsignNotBetween(String value1, String value2) {
            addCriterion("Dsign not between", value1, value2, "dsign");
            return (Criteria) this;
        }

        public Criteria andDsigndateIsNull() {
            addCriterion("DsignDate is null");
            return (Criteria) this;
        }

        public Criteria andDsigndateIsNotNull() {
            addCriterion("DsignDate is not null");
            return (Criteria) this;
        }

        public Criteria andDsigndateEqualTo(Date value) {
            addCriterionForJDBCDate("DsignDate =", value, "dsigndate");
            return (Criteria) this;
        }

        public Criteria andDsigndateNotEqualTo(Date value) {
            addCriterionForJDBCDate("DsignDate <>", value, "dsigndate");
            return (Criteria) this;
        }

        public Criteria andDsigndateGreaterThan(Date value) {
            addCriterionForJDBCDate("DsignDate >", value, "dsigndate");
            return (Criteria) this;
        }

        public Criteria andDsigndateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DsignDate >=", value, "dsigndate");
            return (Criteria) this;
        }

        public Criteria andDsigndateLessThan(Date value) {
            addCriterionForJDBCDate("DsignDate <", value, "dsigndate");
            return (Criteria) this;
        }

        public Criteria andDsigndateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DsignDate <=", value, "dsigndate");
            return (Criteria) this;
        }

        public Criteria andDsigndateIn(List<Date> values) {
            addCriterionForJDBCDate("DsignDate in", values, "dsigndate");
            return (Criteria) this;
        }

        public Criteria andDsigndateNotIn(List<Date> values) {
            addCriterionForJDBCDate("DsignDate not in", values, "dsigndate");
            return (Criteria) this;
        }

        public Criteria andDsigndateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DsignDate between", value1, value2, "dsigndate");
            return (Criteria) this;
        }

        public Criteria andDsigndateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DsignDate not between", value1, value2, "dsigndate");
            return (Criteria) this;
        }

        public Criteria andSsignIsNull() {
            addCriterion("Ssign is null");
            return (Criteria) this;
        }

        public Criteria andSsignIsNotNull() {
            addCriterion("Ssign is not null");
            return (Criteria) this;
        }

        public Criteria andSsignEqualTo(String value) {
            addCriterion("Ssign =", value, "ssign");
            return (Criteria) this;
        }

        public Criteria andSsignNotEqualTo(String value) {
            addCriterion("Ssign <>", value, "ssign");
            return (Criteria) this;
        }

        public Criteria andSsignGreaterThan(String value) {
            addCriterion("Ssign >", value, "ssign");
            return (Criteria) this;
        }

        public Criteria andSsignGreaterThanOrEqualTo(String value) {
            addCriterion("Ssign >=", value, "ssign");
            return (Criteria) this;
        }

        public Criteria andSsignLessThan(String value) {
            addCriterion("Ssign <", value, "ssign");
            return (Criteria) this;
        }

        public Criteria andSsignLessThanOrEqualTo(String value) {
            addCriterion("Ssign <=", value, "ssign");
            return (Criteria) this;
        }

        public Criteria andSsignLike(String value) {
            addCriterion("Ssign like", value, "ssign");
            return (Criteria) this;
        }

        public Criteria andSsignNotLike(String value) {
            addCriterion("Ssign not like", value, "ssign");
            return (Criteria) this;
        }

        public Criteria andSsignIn(List<String> values) {
            addCriterion("Ssign in", values, "ssign");
            return (Criteria) this;
        }

        public Criteria andSsignNotIn(List<String> values) {
            addCriterion("Ssign not in", values, "ssign");
            return (Criteria) this;
        }

        public Criteria andSsignBetween(String value1, String value2) {
            addCriterion("Ssign between", value1, value2, "ssign");
            return (Criteria) this;
        }

        public Criteria andSsignNotBetween(String value1, String value2) {
            addCriterion("Ssign not between", value1, value2, "ssign");
            return (Criteria) this;
        }

        public Criteria andSgradeIsNull() {
            addCriterion("Sgrade is null");
            return (Criteria) this;
        }

        public Criteria andSgradeIsNotNull() {
            addCriterion("Sgrade is not null");
            return (Criteria) this;
        }

        public Criteria andSgradeEqualTo(String value) {
            addCriterion("Sgrade =", value, "sgrade");
            return (Criteria) this;
        }

        public Criteria andSgradeNotEqualTo(String value) {
            addCriterion("Sgrade <>", value, "sgrade");
            return (Criteria) this;
        }

        public Criteria andSgradeGreaterThan(String value) {
            addCriterion("Sgrade >", value, "sgrade");
            return (Criteria) this;
        }

        public Criteria andSgradeGreaterThanOrEqualTo(String value) {
            addCriterion("Sgrade >=", value, "sgrade");
            return (Criteria) this;
        }

        public Criteria andSgradeLessThan(String value) {
            addCriterion("Sgrade <", value, "sgrade");
            return (Criteria) this;
        }

        public Criteria andSgradeLessThanOrEqualTo(String value) {
            addCriterion("Sgrade <=", value, "sgrade");
            return (Criteria) this;
        }

        public Criteria andSgradeLike(String value) {
            addCriterion("Sgrade like", value, "sgrade");
            return (Criteria) this;
        }

        public Criteria andSgradeNotLike(String value) {
            addCriterion("Sgrade not like", value, "sgrade");
            return (Criteria) this;
        }

        public Criteria andSgradeIn(List<String> values) {
            addCriterion("Sgrade in", values, "sgrade");
            return (Criteria) this;
        }

        public Criteria andSgradeNotIn(List<String> values) {
            addCriterion("Sgrade not in", values, "sgrade");
            return (Criteria) this;
        }

        public Criteria andSgradeBetween(String value1, String value2) {
            addCriterion("Sgrade between", value1, value2, "sgrade");
            return (Criteria) this;
        }

        public Criteria andSgradeNotBetween(String value1, String value2) {
            addCriterion("Sgrade not between", value1, value2, "sgrade");
            return (Criteria) this;
        }

        public Criteria andSsigndateIsNull() {
            addCriterion("SsignDate is null");
            return (Criteria) this;
        }

        public Criteria andSsigndateIsNotNull() {
            addCriterion("SsignDate is not null");
            return (Criteria) this;
        }

        public Criteria andSsigndateEqualTo(Date value) {
            addCriterionForJDBCDate("SsignDate =", value, "ssigndate");
            return (Criteria) this;
        }

        public Criteria andSsigndateNotEqualTo(Date value) {
            addCriterionForJDBCDate("SsignDate <>", value, "ssigndate");
            return (Criteria) this;
        }

        public Criteria andSsigndateGreaterThan(Date value) {
            addCriterionForJDBCDate("SsignDate >", value, "ssigndate");
            return (Criteria) this;
        }

        public Criteria andSsigndateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SsignDate >=", value, "ssigndate");
            return (Criteria) this;
        }

        public Criteria andSsigndateLessThan(Date value) {
            addCriterionForJDBCDate("SsignDate <", value, "ssigndate");
            return (Criteria) this;
        }

        public Criteria andSsigndateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SsignDate <=", value, "ssigndate");
            return (Criteria) this;
        }

        public Criteria andSsigndateIn(List<Date> values) {
            addCriterionForJDBCDate("SsignDate in", values, "ssigndate");
            return (Criteria) this;
        }

        public Criteria andSsigndateNotIn(List<Date> values) {
            addCriterionForJDBCDate("SsignDate not in", values, "ssigndate");
            return (Criteria) this;
        }

        public Criteria andSsigndateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SsignDate between", value1, value2, "ssigndate");
            return (Criteria) this;
        }

        public Criteria andSsigndateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SsignDate not between", value1, value2, "ssigndate");
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

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("Remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("Remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("Remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("Remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("Remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("Remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("Remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("Remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("Remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("Remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("Remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("Remarks not between", value1, value2, "remarks");
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