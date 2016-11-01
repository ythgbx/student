package net.bus.web.model.Pojo;

/**分页界面需要的数据
 * Created by sky on 16/11/1.
 */
public class PagePojo {
    private int amount;//总条数
    private int countPage;//总页数
    private int limit;//每页条数
    private int homePage;//首页
    private int trailerPage;//尾页
    private int currentPage; //当前页
    private int previousPage; //上一页
    private int nextPage; //下一页

    public PagePojo(int amount,int limit,int page) {
        this.amount = amount;
        this.limit = limit;
        this.currentPage = page;
    }

    public PagePojo() {
    }

    public PagePojo(int amount, int currentPage, int previousPage, int Page) {
        this.amount = amount;
        this.currentPage = currentPage;
        this.previousPage = previousPage;
        this.nextPage = Page;
        setCurrentPage(Page);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCountPage() {
        setCountPage();
        if (this.countPage==0){
            return 1;
        }
        return countPage;
    }

    public void setCountPage() {
        if (this.amount%this.limit==0){
            this.countPage=this.amount/this.limit;
        }else {
            this.countPage=this.amount/this.limit+1;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getHomePage() {
        setHomePage();
        return homePage;
    }

    public void setHomePage() {
        this.homePage = 0;
    }

    public int getTrailerPage() {
        setTrailerPage();
        return trailerPage;
    }

    public void setTrailerPage() {
        this.trailerPage = this.countPage;
    }

    public int getCurrentPage() {
        setCurrentPage(currentPage);
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPreviousPage() {  //上一页
        setPreviousPage();
        return previousPage;
    }

    public void setPreviousPage() {
        if (this.currentPage <= 0) {
            this.previousPage = this.currentPage;
        } else {
            this.previousPage = currentPage-1;
        }

    }
    public int getNextPage() {
        setNextPage();
        return nextPage;
    }

    public void setNextPage() {
        if (this.currentPage>=this.countPage-1){
            this.nextPage = this.currentPage;
        }else {
            this.nextPage = currentPage+1;
        }
    }
}
