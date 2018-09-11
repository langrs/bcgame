package com.wm.bcgame;




import java.util.ArrayList;
import java.util.List;

/**
 * @author LZM
 * @description
 * @date 10:29 2018/9/11
 * @mondified
 **/
public class MainTest {
	private String ak47 ="[hb10, usdt, btc, bch, eth, xrp, ltc, ht, ada, eos, iota, xem, xmr, dash, neo, trx, icx, lsk, qtum, etc, btg, omg, hc, zec, dcr, steem, bts, waves, snt, salt, gnt, cmt, btm, pay, knc, powr, bat, dgd, ven, qash, zrx, gas, mana, eng, cvc, mco, mtl, rdn, storj, chat, srn, link, act, tnb, qsp, req, rpx, appc, rcn, smt, adx, tnt, ost, itc, lun, gnx, ast, evx, mds, snc, propy, eko, nas, bcd, wax, wicc, topc, swftc, dbc, elf, aidoc, qun, iost, yee, dat, theta, let, dta, utk, meet, zil, soc, ruff, ocn, ela, bcx, sbtc, etf, bifi, zla, stk, wpr, mtn, mtx, edu, blz, abt, ont, ctxc, bft, wan, kan, lba, poly, pai, wtc, box, dgb, gxs, bix, xlm, xvg, hit, ong, bt1, bt2, xzc, vet, ncash]";

	public static void main(String[] args) {

//		String[] a = {"copy","mme"};
//		List<String> list = java.util.Arrays.asList(a);
//
//		System.out.println(list);
		List<String> a = new ArrayList<String>();
		a.add("abc1");
		a.add("abc2");
		a.add("abc3");
		String str = a.toString();
		str = str.substring(1,str.length() - 1 );
		String[] kk = str.split(",");
		for(String b:kk){
			System.out.println(b.trim());
		}
	}
}
