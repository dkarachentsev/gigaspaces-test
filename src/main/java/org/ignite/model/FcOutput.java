package org.ignite.model;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
//import org.apache.ignite.cache.query.annotations.QuerySqlField;

@SpaceClass
public class FcOutput implements Serializable {

    private static int numberOfFcstClass = 10;
    private static int  numberOfInfluencePeriod = 7;
    private static int numberOfPos = 3;
    private static int  numberOfFlowIndicator = 2;
    private static int initalValue =-1;
    //private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

//    @QuerySqlField(index = true)
    private String legOrig;
//    @QuerySqlField(index = true)
    private String legDest;
//    @QuerySqlField(index = true)
    private long fltDptrDate;
//    @QuerySqlField(index = true)
    private int fcstId;
//    @QuerySqlField(index = true)
    private int fcstDoW;
//    @QuerySqlField(index = true)
    private int poolCd;
//    @QuerySqlField(index = true)
    private char cabinCode;
//    @QuerySqlField(index = true)
    private int flightId;
    private int flightNumber;
    private int driverIdx;
    private int[] posValues;
    private Long key;

    private FcResult[][][][] foreCastResult;

    public FcOutput() {
    }

    /**
     * Constructs ForcastOutput record.
     * @param legOrig        LEG_ORIG
     * @param legDest        LEG_DEST
     * @param fltDptrDate    FLT_DPTR_DATE
     * @param fcstId         fcst_id
     * @param fcstDoW        fcst_dow
     * @param poolCd         pool_cd
     * @param cabinCode      cabin_code
     * @param flightId       flight_id
     * @param flightNumber   flightNumber
     * @param driverIdx      flightNumber
     *
     **/
    public FcOutput(String legOrig, String legDest, long fltDptrDate, int fcstId, int fcstDoW, int poolCd,
        char cabinCode, int flightId, int flightNumber, int driverIdx){

        this.legOrig = legOrig;
        this.legDest = legDest;
        this.fltDptrDate = fltDptrDate;
        this.fcstId = fcstId;
        this.fcstDoW = fcstDoW;
        this.poolCd = poolCd;
        this.cabinCode = cabinCode;

        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.driverIdx = driverIdx;
        foreCastResult = new FcResult[numberOfFcstClass][numberOfInfluencePeriod][numberOfPos][numberOfFlowIndicator];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        //this.key =  (new Long(simpleDateFormat.format(new Date(fltDptrDate)))*100000000L) + new Long(flightId)*100L + cabinCode;
        key = new Long(flightId) * 10000000000L + (new Long(simpleDateFormat.format(new Date(fltDptrDate)))*100L) + cabinCode;

        posValues = new int[numberOfPos];
        for (int i=0;i<numberOfPos;i++)
            posValues[i] = initalValue;
    }

    public void setFcstResult(int fcstCls, int influencePrd, int pos, int flowIndc, FcResult fcResult){
        if(influencePrd < numberOfInfluencePeriod)
            foreCastResult[fcstCls-1][influencePrd][pos][flowIndc] = fcResult;
    }

    public FcResult getFcstResult(int fcstCls, int influencePrd, int pos, int flowIndc){
        return (foreCastResult[fcstCls][influencePrd][pos][flowIndc]);
    }

    @SpaceRouting
    @SpaceId
    public Long getKey(){

        return (this.key);
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public static int getInitalValue() {
        return initalValue;
    }

    public static void setInitalValue(int initalValue) {
        FcOutput.initalValue = initalValue;
    }

    public String getLegOrig() {
        return legOrig;
    }

    public void setLegOrig(String legOrig) {
        this.legOrig = legOrig;
    }

    public String getLegDest() {
        return legDest;
    }

    public void setLegDest(String legDest) {
        this.legDest = legDest;
    }

    public long getFltDptrDate() {
        return fltDptrDate;
    }

    public void setFltDptrDate(long fltDptrDate) {
        this.fltDptrDate = fltDptrDate;
    }

    public int getFcstId() {
        return fcstId;
    }

    public void setFcstId(int fcstId) {
        this.fcstId = fcstId;
    }

    public int getFcstDoW() {
        return fcstDoW;
    }

    public void setFcstDoW(int fcstDoW) {
        this.fcstDoW = fcstDoW;
    }

    public int getPoolCd() {
        return poolCd;
    }

    public void setPoolCd(int poolCd) {
        this.poolCd = poolCd;
    }

    public char getCabinCode() {
        return cabinCode;
    }

    public void setCabinCode(char cabinCode) {
        this.cabinCode = cabinCode;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getDriverIdx() {
        return driverIdx;
    }

    public void setDriverIdx(int driverIdx) {
        this.driverIdx = driverIdx;
    }

    public int[] getPosValues() {
        return posValues;
    }

    public void setPosValues(int[] posValues) {
        this.posValues = posValues;
    }

    public FcResult[][][][] getForeCastResult() {
        return foreCastResult;
    }

    public void setForeCastResult(FcResult[][][][] foreCastResult) {
        this.foreCastResult = foreCastResult;
    }

    @Override
    public String toString() {
        return ( "legOrig = " + legOrig +
                ",legDest = "  + legDest +
                ",fltDptrDate = "  + fltDptrDate +
                ",fcstId = " + fcstId +
                ",fcstDoW = " + fcstDoW +
                ",poolCd = " + poolCd +
                ",cabinCode = " + cabinCode +
                ",flightId = " + flightId +
                ",flightNumber = " + flightNumber +
                ",driverIdx = " + driverIdx);
    }
}
