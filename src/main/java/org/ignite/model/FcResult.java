package org.ignite.model;

import java.io.Serializable;

public class FcResult implements Serializable {

    private int mwpPureFcst;
    private int mwpFcst;
    private int userMwpFcst;
    private int mwpRemainDmd;
    private int lwMwpFcst;
    private int lmMwpFcst;
    private int lyMwpFcst;


    /**
     * Constructs ForeCastResult record.
     * @param mwpPureFcst   mwpPureFcst
     * @param mwpFcst       mwpFcst
     * @param userMwpFcst   userMwpFcst
     * @param mwpRemainDmd  mwpRemainDmd
     * @param lwMwpFcst     lwMwpFcst
     * @param lmMwpFcst     lmMwpFcst
     * @param lyMwpFcst     lyMwpFcst
     *
     **/

    public FcResult(int mwpPureFcst, int mwpFcst, int userMwpFcst, int mwpRemainDmd, int lwMwpFcst, int lmMwpFcst, int lyMwpFcst)
    {

        this.mwpPureFcst = mwpPureFcst;
        this.mwpFcst = mwpFcst;
        this.userMwpFcst = userMwpFcst;
        this.mwpRemainDmd = mwpRemainDmd;
        this.lwMwpFcst = lwMwpFcst;
        this.lmMwpFcst = lmMwpFcst;
        this.lyMwpFcst = lyMwpFcst;
    }

    @Override
    public String toString() {
        return ( "mwpPureFcst = " + mwpPureFcst +
                ",mwpFcst = " + mwpFcst +
                ",userMwpFcst = " + userMwpFcst +
                ",mwpRemainDmd = " + mwpRemainDmd +
                ",lwMwpFcst = " + lwMwpFcst +
                ",lmMwpFcst = " + lmMwpFcst +
                ", lyMwpFcst = " + lyMwpFcst);
    }
}
