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

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLastyearmoneyIsNull() {
            addCriterion("lastyearMoney is null");
            return (Criteria) this;
        }

        public Criteria andLastyearmoneyIsNotNull() {
            addCriterion("lastyearMoney is not null");
            return (Criteria) this;
        }

        public Criteria andLastyearmoneyEqualTo(String value) {
            addCriterion("lastyearMoney =", value, "lastyearmoney");
            return (Criteria) this;
        }

        public Criteria andLastyearmoneyNotEqualTo(String value) {
            addCriterion("lastyearMoney <>", value, "lastyearmoney");
            return (Criteria) this;
        }

        public Criteria andLastyearmoneyGreaterThan(String value) {
            addCriterion("lastyearMoney >", value, "lastyearmoney");
            return (Criteria) this;
        }

        public Criteria andLastyearmoneyGreaterThanOrEqualTo(String value) {
            addCriterion("lastyearMoney >=", value, "lastyearmoney");
            return (Criteria) this;
        }

        public Criteria andLastyearmoneyLessThan(String value) {
            addCriterion("lastyearMoney <", value, "lastyearmoney");
            return (Criteria) this;
        }

        public Criteria andLastyearmoneyLessThanOrEqualTo(String value) {
            addCriterion("lastyearMoney <=", value, "lastyearmoney");
            return (Criteria) this;
        }

        public Criteria andLastyearmoneyLike(String value) {
            addCriterion("lastyearMoney like", value, "lastyearmoney");
            return (Criteria) this;
        }

        public Criteria andLastyearmoneyNotLike(String value) {
            addCriterion("lastyearMoney not like", value, "lastyearmoney");
            return (Criteria) this;
        }

        public Criteria andLastyearmoneyIn(List<String> values) {
            addCriterion("lastyearMoney in", values, "lastyearmoney");
            return (Criteria) this;
        }

        public Criteria andLastyearmoneyNotIn(List<String> values) {
            addCriterion("lastyearMoney not in", values, "lastyearmoney");
            return (Criteria) this;
        }

        public Criteria andLastyearmoneyBetween(String value1, String value2) {
            addCriterion("lastyearMoney between", value1, value2, "lastyearmoney");
            return (Criteria) this;
        }

        public Criteria andLastyearmoneyNotBetween(String value1, String value2) {
            addCriterion("lastyearMoney not between", value1, value2, "lastyearmoney");
            return (Criteria) this;
        }

        public Criteria andUseoffundsIsNull() {
            addCriterion("useofFunds is null");
            return (Criteria) this;
        }

        public Criteria andUseoffundsIsNotNull() {
            addCriterion("useofFunds is not null");
            return (Criteria) this;
        }

        public Criteria andUseoffundsEqualTo(String value) {
            addCriterion("useofFunds =", value, "useoffunds");
            return (Criteria) this;
        }

        public Criteria andUseoffundsNotEqualTo(String value) {
            addCriterion("useofFunds <>", value, "useoffunds");
            return (Criteria) this;
        }

        public Criteria andUseoffundsGreaterThan(String value) {
            addCriterion("useofFunds >", value, "useoffunds");
            return (Criteria) this;
        }

        public Criteria andUseoffundsGreaterThanOrEqualTo(String value) {
            addCriterion("useofFunds >=", value, "useoffunds");
            return (Criteria) this;
        }

        public Criteria andUseoffundsLessThan(String value) {
            addCriterion("useofFunds <", value, "useoffunds");
            return (Criteria) this;
        }

        public Criteria andUseoffundsLessThanOrEqualTo(String value) {
            addCriterion("useofFunds <=", value, "useoffunds");
            return (Criteria) this;
        }

        public Criteria andUseoffundsLike(String value) {
            addCriterion("useofFunds like", value, "useoffunds");
            return (Criteria) this;
        }

        public Criteria andUseoffundsNotLike(String value) {
            addCriterion("useofFunds not like", value, "useoffunds");
            return (Criteria) this;
        }

        public Criteria andUseoffundsIn(List<String> values) {
            addCriterion("useofFunds in", values, "useoffunds");
            return (Criteria) this;
        }

        public Criteria andUseoffundsNotIn(List<String> values) {
            addCriterion("useofFunds not in", values, "useoffunds");
            return (Criteria) this;
        }

        public Criteria andUseoffundsBetween(String value1, String value2) {
            addCriterion("useofFunds between", value1, value2, "useoffunds");
            return (Criteria) this;
        }

        public Criteria andUseoffundsNotBetween(String value1, String value2) {
            addCriterion("useofFunds not between", value1, value2, "useoffunds");
            return (Criteria) this;
        }

        public Criteria andThisuseIsNull() {
            addCriterion("thisUse is null");
            return (Criteria) this;
        }

        public Criteria andThisuseIsNotNull() {
            addCriterion("thisUse is not null");
            return (Criteria) this;
        }

        public Criteria andThisuseEqualTo(String value) {
            addCriterion("thisUse =", value, "thisuse");
            return (Criteria) this;
        }

        public Criteria andThisuseNotEqualTo(String value) {
            addCriterion("thisUse <>", value, "thisuse");
            return (Criteria) this;
        }

        public Criteria andThisuseGreaterThan(String value) {
            addCriterion("thisUse >", value, "thisuse");
            return (Criteria) this;
        }

        public Criteria andThisuseGreaterThanOrEqualTo(String value) {
            addCriterion("thisUse >=", value, "thisuse");
            return (Criteria) this;
        }

        public Criteria andThisuseLessThan(String value) {
            addCriterion("thisUse <", value, "thisuse");
            return (Criteria) this;
        }

        public Criteria andThisuseLessThanOrEqualTo(String value) {
            addCriterion("thisUse <=", value, "thisuse");
            return (Criteria) this;
        }

        public Criteria andThisuseLike(String value) {
            addCriterion("thisUse like", value, "thisuse");
            return (Criteria) this;
        }

        public Criteria andThisuseNotLike(String value) {
            addCriterion("thisUse not like", value, "thisuse");
            return (Criteria) this;
        }

        public Criteria andThisuseIn(List<String> values) {
            addCriterion("thisUse in", values, "thisuse");
            return (Criteria) this;
        }

        public Criteria andThisuseNotIn(List<String> values) {
            addCriterion("thisUse not in", values, "thisuse");
            return (Criteria) this;
        }

        public Criteria andThisuseBetween(String value1, String value2) {
            addCriterion("thisUse between", value1, value2, "thisuse");
            return (Criteria) this;
        }

        public Criteria andThisuseNotBetween(String value1, String value2) {
            addCriterion("thisUse not between", value1, value2, "thisuse");
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

        public Criteria andTotalnumIsNull() {
            addCriterion("totalNum is null");
            return (Criteria) this;
        }

        public Criteria andTotalnumIsNotNull() {
            addCriterion("totalNum is not null");
            return (Criteria) this;
        }

        public Criteria andTotalnumEqualTo(String value) {
            addCriterion("totalNum =", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumNotEqualTo(String value) {
            addCriterion("totalNum <>", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumGreaterThan(String value) {
            addCriterion("totalNum >", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumGreaterThanOrEqualTo(String value) {
            addCriterion("totalNum >=", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumLessThan(String value) {
            addCriterion("totalNum <", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumLessThanOrEqualTo(String value) {
            addCriterion("totalNum <=", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumLike(String value) {
            addCriterion("totalNum like", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumNotLike(String value) {
            addCriterion("totalNum not like", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumIn(List<String> values) {
            addCriterion("totalNum in", values, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumNotIn(List<String> values) {
            addCriterion("totalNum not in", values, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumBetween(String value1, String value2) {
            addCriterion("totalNum between", value1, value2, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumNotBetween(String value1, String value2) {
            addCriterion("totalNum not between", value1, value2, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIsNull() {
            addCriterion("totalMoney is null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIsNotNull() {
            addCriterion("totalMoney is not null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyEqualTo(String value) {
            addCriterion("totalMoney =", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotEqualTo(String value) {
            addCriterion("totalMoney <>", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThan(String value) {
            addCriterion("totalMoney >", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThanOrEqualTo(String value) {
            addCriterion("totalMoney >=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThan(String value) {
            addCriterion("totalMoney <", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThanOrEqualTo(String value) {
            addCriterion("totalMoney <=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLike(String value) {
            addCriterion("totalMoney like", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotLike(String value) {
            addCriterion("totalMoney not like", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIn(List<String> values) {
            addCriterion("totalMoney in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotIn(List<String> values) {
            addCriterion("totalMoney not in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyBetween(String value1, String value2) {
            addCriterion("totalMoney between", value1, value2, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotBetween(String value1, String value2) {
            addCriterion("totalMoney not between", value1, value2, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andAvemoneyIsNull() {
            addCriterion("aveMoney is null");
            return (Criteria) this;
        }

        public Criteria andAvemoneyIsNotNull() {
            addCriterion("aveMoney is not null");
            return (Criteria) this;
        }

        public Criteria andAvemoneyEqualTo(String value) {
            addCriterion("aveMoney =", value, "avemoney");
            return (Criteria) this;
        }

        public Criteria andAvemoneyNotEqualTo(String value) {
            addCriterion("aveMoney <>", value, "avemoney");
            return (Criteria) this;
        }

        public Criteria andAvemoneyGreaterThan(String value) {
            addCriterion("aveMoney >", value, "avemoney");
            return (Criteria) this;
        }

        public Criteria andAvemoneyGreaterThanOrEqualTo(String value) {
            addCriterion("aveMoney >=", value, "avemoney");
            return (Criteria) this;
        }

        public Criteria andAvemoneyLessThan(String value) {
            addCriterion("aveMoney <", value, "avemoney");
            return (Criteria) this;
        }

        public Criteria andAvemoneyLessThanOrEqualTo(String value) {
            addCriterion("aveMoney <=", value, "avemoney");
            return (Criteria) this;
        }

        public Criteria andAvemoneyLike(String value) {
            addCriterion("aveMoney like", value, "avemoney");
            return (Criteria) this;
        }

        public Criteria andAvemoneyNotLike(String value) {
            addCriterion("aveMoney not like", value, "avemoney");
            return (Criteria) this;
        }

        public Criteria andAvemoneyIn(List<String> values) {
            addCriterion("aveMoney in", values, "avemoney");
            return (Criteria) this;
        }

        public Criteria andAvemoneyNotIn(List<String> values) {
            addCriterion("aveMoney not in", values, "avemoney");
            return (Criteria) this;
        }

        public Criteria andAvemoneyBetween(String value1, String value2) {
            addCriterion("aveMoney between", value1, value2, "avemoney");
            return (Criteria) this;
        }

        public Criteria andAvemoneyNotBetween(String value1, String value2) {
            addCriterion("aveMoney not between", value1, value2, "avemoney");
            return (Criteria) this;
        }

        public Criteria andEsourcesIsNull() {
            addCriterion("Esources is null");
            return (Criteria) this;
        }

        public Criteria andEsourcesIsNotNull() {
            addCriterion("Esources is not null");
            return (Criteria) this;
        }

        public Criteria andEsourcesEqualTo(String value) {
            addCriterion("Esources =", value, "esources");
            return (Criteria) this;
        }

        public Criteria andEsourcesNotEqualTo(String value) {
            addCriterion("Esources <>", value, "esources");
            return (Criteria) this;
        }

        public Criteria andEsourcesGreaterThan(String value) {
            addCriterion("Esources >", value, "esources");
            return (Criteria) this;
        }

        public Criteria andEsourcesGreaterThanOrEqualTo(String value) {
            addCriterion("Esources >=", value, "esources");
            return (Criteria) this;
        }

        public Criteria andEsourcesLessThan(String value) {
            addCriterion("Esources <", value, "esources");
            return (Criteria) this;
        }

        public Criteria andEsourcesLessThanOrEqualTo(String value) {
            addCriterion("Esources <=", value, "esources");
            return (Criteria) this;
        }

        public Criteria andEsourcesLike(String value) {
            addCriterion("Esources like", value, "esources");
            return (Criteria) this;
        }

        public Criteria andEsourcesNotLike(String value) {
            addCriterion("Esources not like", value, "esources");
            return (Criteria) this;
        }

        public Criteria andEsourcesIn(List<String> values) {
            addCriterion("Esources in", values, "esources");
            return (Criteria) this;
        }

        public Criteria andEsourcesNotIn(List<String> values) {
            addCriterion("Esources not in", values, "esources");
            return (Criteria) this;
        }

        public Criteria andEsourcesBetween(String value1, String value2) {
            addCriterion("Esources between", value1, value2, "esources");
            return (Criteria) this;
        }

        public Criteria andEsourcesNotBetween(String value1, String value2) {
            addCriterion("Esources not between", value1, value2, "esources");
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

        public Criteria andDatetimeIsNull() {
            addCriterion("datetime is null");
            return (Criteria) this;
        }

        public Criteria andDatetimeIsNotNull() {
            addCriterion("datetime is not null");
            return (Criteria) this;
        }

        public Criteria andDatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("datetime =", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("datetime <>", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("datetime >", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("datetime >=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThan(Date value) {
            addCriterionForJDBCDate("datetime <", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("datetime <=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("datetime in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("datetime not in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("datetime between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("datetime not between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andDsuggestIsNull() {
            addCriterion("dsuggest is null");
            return (Criteria) this;
        }

        public Criteria andDsuggestIsNotNull() {
            addCriterion("dsuggest is not null");
            return (Criteria) this;
        }

        public Criteria andDsuggestEqualTo(String value) {
            addCriterion("dsuggest =", value, "dsuggest");
            return (Criteria) this;
        }

        public Criteria andDsuggestNotEqualTo(String value) {
            addCriterion("dsuggest <>", value, "dsuggest");
            return (Criteria) this;
        }

        public Criteria andDsuggestGreaterThan(String value) {
            addCriterion("dsuggest >", value, "dsuggest");
            return (Criteria) this;
        }

        public Criteria andDsuggestGreaterThanOrEqualTo(String value) {
            addCriterion("dsuggest >=", value, "dsuggest");
            return (Criteria) this;
        }

        public Criteria andDsuggestLessThan(String value) {
            addCriterion("dsuggest <", value, "dsuggest");
            return (Criteria) this;
        }

        public Criteria andDsuggestLessThanOrEqualTo(String value) {
            addCriterion("dsuggest <=", value, "dsuggest");
            return (Criteria) this;
        }

        public Criteria andDsuggestLike(String value) {
            addCriterion("dsuggest like", value, "dsuggest");
            return (Criteria) this;
        }

        public Criteria andDsuggestNotLike(String value) {
            addCriterion("dsuggest not like", value, "dsuggest");
            return (Criteria) this;
        }

        public Criteria andDsuggestIn(List<String> values) {
            addCriterion("dsuggest in", values, "dsuggest");
            return (Criteria) this;
        }

        public Criteria andDsuggestNotIn(List<String> values) {
            addCriterion("dsuggest not in", values, "dsuggest");
            return (Criteria) this;
        }

        public Criteria andDsuggestBetween(String value1, String value2) {
            addCriterion("dsuggest between", value1, value2, "dsuggest");
            return (Criteria) this;
        }

        public Criteria andDsuggestNotBetween(String value1, String value2) {
            addCriterion("dsuggest not between", value1, value2, "dsuggest");
            return (Criteria) this;
        }

        public Criteria andDdatetimeIsNull() {
            addCriterion("ddatetime is null");
            return (Criteria) this;
        }

        public Criteria andDdatetimeIsNotNull() {
            addCriterion("ddatetime is not null");
            return (Criteria) this;
        }

        public Criteria andDdatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("ddatetime =", value, "ddatetime");
            return (Criteria) this;
        }

        public Criteria andDdatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ddatetime <>", value, "ddatetime");
            return (Criteria) this;
        }

        public Criteria andDdatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ddatetime >", value, "ddatetime");
            return (Criteria) this;
        }

        public Criteria andDdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ddatetime >=", value, "ddatetime");
            return (Criteria) this;
        }

        public Criteria andDdatetimeLessThan(Date value) {
            addCriterionForJDBCDate("ddatetime <", value, "ddatetime");
            return (Criteria) this;
        }

        public Criteria andDdatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ddatetime <=", value, "ddatetime");
            return (Criteria) this;
        }

        public Criteria andDdatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("ddatetime in", values, "ddatetime");
            return (Criteria) this;
        }

        public Criteria andDdatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ddatetime not in", values, "ddatetime");
            return (Criteria) this;
        }

        public Criteria andDdatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ddatetime between", value1, value2, "ddatetime");
            return (Criteria) this;
        }

        public Criteria andDdatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ddatetime not between", value1, value2, "ddatetime");
            return (Criteria) this;
        }

        public Criteria andSdatetimeIsNull() {
            addCriterion("sdatetime is null");
            return (Criteria) this;
        }

        public Criteria andSdatetimeIsNotNull() {
            addCriterion("sdatetime is not null");
            return (Criteria) this;
        }

        public Criteria andSdatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("sdatetime =", value, "sdatetime");
            return (Criteria) this;
        }

        public Criteria andSdatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("sdatetime <>", value, "sdatetime");
            return (Criteria) this;
        }

        public Criteria andSdatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("sdatetime >", value, "sdatetime");
            return (Criteria) this;
        }

        public Criteria andSdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sdatetime >=", value, "sdatetime");
            return (Criteria) this;
        }

        public Criteria andSdatetimeLessThan(Date value) {
            addCriterionForJDBCDate("sdatetime <", value, "sdatetime");
            return (Criteria) this;
        }

        public Criteria andSdatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sdatetime <=", value, "sdatetime");
            return (Criteria) this;
        }

        public Criteria andSdatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("sdatetime in", values, "sdatetime");
            return (Criteria) this;
        }

        public Criteria andSdatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("sdatetime not in", values, "sdatetime");
            return (Criteria) this;
        }

        public Criteria andSdatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sdatetime between", value1, value2, "sdatetime");
            return (Criteria) this;
        }

        public Criteria andSdatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sdatetime not between", value1, value2, "sdatetime");
            return (Criteria) this;
        }

        public Criteria andTreviewedIsNull() {
            addCriterion("Treviewed is null");
            return (Criteria) this;
        }

        public Criteria andTreviewedIsNotNull() {
            addCriterion("Treviewed is not null");
            return (Criteria) this;
        }

        public Criteria andTreviewedEqualTo(String value) {
            addCriterion("Treviewed =", value, "treviewed");
            return (Criteria) this;
        }

        public Criteria andTreviewedNotEqualTo(String value) {
            addCriterion("Treviewed <>", value, "treviewed");
            return (Criteria) this;
        }

        public Criteria andTreviewedGreaterThan(String value) {
            addCriterion("Treviewed >", value, "treviewed");
            return (Criteria) this;
        }

        public Criteria andTreviewedGreaterThanOrEqualTo(String value) {
            addCriterion("Treviewed >=", value, "treviewed");
            return (Criteria) this;
        }

        public Criteria andTreviewedLessThan(String value) {
            addCriterion("Treviewed <", value, "treviewed");
            return (Criteria) this;
        }

        public Criteria andTreviewedLessThanOrEqualTo(String value) {
            addCriterion("Treviewed <=", value, "treviewed");
            return (Criteria) this;
        }

        public Criteria andTreviewedLike(String value) {
            addCriterion("Treviewed like", value, "treviewed");
            return (Criteria) this;
        }

        public Criteria andTreviewedNotLike(String value) {
            addCriterion("Treviewed not like", value, "treviewed");
            return (Criteria) this;
        }

        public Criteria andTreviewedIn(List<String> values) {
            addCriterion("Treviewed in", values, "treviewed");
            return (Criteria) this;
        }

        public Criteria andTreviewedNotIn(List<String> values) {
            addCriterion("Treviewed not in", values, "treviewed");
            return (Criteria) this;
        }

        public Criteria andTreviewedBetween(String value1, String value2) {
            addCriterion("Treviewed between", value1, value2, "treviewed");
            return (Criteria) this;
        }

        public Criteria andTreviewedNotBetween(String value1, String value2) {
            addCriterion("Treviewed not between", value1, value2, "treviewed");
            return (Criteria) this;
        }

        public Criteria andDtreviewedIsNull() {
            addCriterion("DTreviewed is null");
            return (Criteria) this;
        }

        public Criteria andDtreviewedIsNotNull() {
            addCriterion("DTreviewed is not null");
            return (Criteria) this;
        }

        public Criteria andDtreviewedEqualTo(String value) {
            addCriterion("DTreviewed =", value, "dtreviewed");
            return (Criteria) this;
        }

        public Criteria andDtreviewedNotEqualTo(String value) {
            addCriterion("DTreviewed <>", value, "dtreviewed");
            return (Criteria) this;
        }

        public Criteria andDtreviewedGreaterThan(String value) {
            addCriterion("DTreviewed >", value, "dtreviewed");
            return (Criteria) this;
        }

        public Criteria andDtreviewedGreaterThanOrEqualTo(String value) {
            addCriterion("DTreviewed >=", value, "dtreviewed");
            return (Criteria) this;
        }

        public Criteria andDtreviewedLessThan(String value) {
            addCriterion("DTreviewed <", value, "dtreviewed");
            return (Criteria) this;
        }

        public Criteria andDtreviewedLessThanOrEqualTo(String value) {
            addCriterion("DTreviewed <=", value, "dtreviewed");
            return (Criteria) this;
        }

        public Criteria andDtreviewedLike(String value) {
            addCriterion("DTreviewed like", value, "dtreviewed");
            return (Criteria) this;
        }

        public Criteria andDtreviewedNotLike(String value) {
            addCriterion("DTreviewed not like", value, "dtreviewed");
            return (Criteria) this;
        }

        public Criteria andDtreviewedIn(List<String> values) {
            addCriterion("DTreviewed in", values, "dtreviewed");
            return (Criteria) this;
        }

        public Criteria andDtreviewedNotIn(List<String> values) {
            addCriterion("DTreviewed not in", values, "dtreviewed");
            return (Criteria) this;
        }

        public Criteria andDtreviewedBetween(String value1, String value2) {
            addCriterion("DTreviewed between", value1, value2, "dtreviewed");
            return (Criteria) this;
        }

        public Criteria andDtreviewedNotBetween(String value1, String value2) {
            addCriterion("DTreviewed not between", value1, value2, "dtreviewed");
            return (Criteria) this;
        }

        public Criteria andStreviewedIsNull() {
            addCriterion("STreviewed is null");
            return (Criteria) this;
        }

        public Criteria andStreviewedIsNotNull() {
            addCriterion("STreviewed is not null");
            return (Criteria) this;
        }

        public Criteria andStreviewedEqualTo(String value) {
            addCriterion("STreviewed =", value, "streviewed");
            return (Criteria) this;
        }

        public Criteria andStreviewedNotEqualTo(String value) {
            addCriterion("STreviewed <>", value, "streviewed");
            return (Criteria) this;
        }

        public Criteria andStreviewedGreaterThan(String value) {
            addCriterion("STreviewed >", value, "streviewed");
            return (Criteria) this;
        }

        public Criteria andStreviewedGreaterThanOrEqualTo(String value) {
            addCriterion("STreviewed >=", value, "streviewed");
            return (Criteria) this;
        }

        public Criteria andStreviewedLessThan(String value) {
            addCriterion("STreviewed <", value, "streviewed");
            return (Criteria) this;
        }

        public Criteria andStreviewedLessThanOrEqualTo(String value) {
            addCriterion("STreviewed <=", value, "streviewed");
            return (Criteria) this;
        }

        public Criteria andStreviewedLike(String value) {
            addCriterion("STreviewed like", value, "streviewed");
            return (Criteria) this;
        }

        public Criteria andStreviewedNotLike(String value) {
            addCriterion("STreviewed not like", value, "streviewed");
            return (Criteria) this;
        }

        public Criteria andStreviewedIn(List<String> values) {
            addCriterion("STreviewed in", values, "streviewed");
            return (Criteria) this;
        }

        public Criteria andStreviewedNotIn(List<String> values) {
            addCriterion("STreviewed not in", values, "streviewed");
            return (Criteria) this;
        }

        public Criteria andStreviewedBetween(String value1, String value2) {
            addCriterion("STreviewed between", value1, value2, "streviewed");
            return (Criteria) this;
        }

        public Criteria andStreviewedNotBetween(String value1, String value2) {
            addCriterion("STreviewed not between", value1, value2, "streviewed");
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