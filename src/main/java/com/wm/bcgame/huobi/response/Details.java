package com.wm.bcgame.huobi.response;

/**
 * @Author ISME
 * @Date 2018/1/14
 * @Time 15:33
 */

public class Details {

    /**
     * amount : 4316.4346
     * open : 8090.54
     * close : 7962.62
     * high : 8119
     * ts : 1489464451000
     * id : 1489464451
     * count : 9595
     * low : 7875
     * vol : 3.449727690576E7
     */

    private double amount;
    private double open;
    private double close;
    private double high;
    private long ts;
    private Long id;
    private int count;
    private double low;
    private double vol;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getVol() {
        return vol;
    }

    public void setVol(double vol) {
        this.vol = vol;
    }

	@Override
	public String toString() {
		return "Details{" +
				"amount=" + amount +
				", open=" + open +
				", close=" + close +
				", high=" + high +
				", ts=" + ts +
				", id=" + id +
				", count=" + count +
				", low=" + low +
				", vol=" + vol +
				'}';
	}
}
