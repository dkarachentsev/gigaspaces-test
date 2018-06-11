package org.ignite.model;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import com.aa.model.*;
import org.apache.ignite.*;
import org.apache.ignite.lang.IgniteRunnable;
import java.text.SimpleDateFormat;

public class FcstRunnable  implements IgniteRunnable{

//    private static final Logger LOGGER = Logger.getLogger(new Object(){}.getClass());
    private String cacheName;
    private String dirName;
    private String fileName;
    //private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    public FcstRunnable(String cacheName, String dirName, String fileName){
        this.cacheName = cacheName;
        this.dirName = dirName;
        this.fileName = fileName;
    }

    @Override
    public void run() {

//        try (IgniteDataStreamer<Long,FcOutput>  dataStreamer = Ignition.ignite().dataStreamer(cacheName)){
//
//            try {
//
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
//                //DeSerializing the objects
//                DatumReader<RmFile> fcstDatumReader = new SpecificDatumReader<RmFile>(RmFile.class);
//                String absoluteFilePath = dirName + File.separator + fileName;
//
//                    try {
//
//                        DataFileReader<RmFile> dataFileReader = new DataFileReader<RmFile>(new File(absoluteFilePath), fcstDatumReader);
//                        RmFile fcst = null;
//                        while (dataFileReader.hasNext()) {
//
//                            fcst = dataFileReader.next(fcst);
//                            for (FlightType ft : fcst.getFlightLeg()) {
//
//                                FcOutput fcstOutput = null;
//                                Date fltDptrDate = null;
//                                /*
//                                Date fltDptrDate1 = null;
//                                String fltDptrDateSimplePars = null;
//                                try {
//                                    fltDptrDate1 = ft.getDepartureDate().toDate();
//                                } catch( Exception ex){
//                                    System.out.println("While getting from influnce:" + ft.getDepartureDate()  + "file name" + absoluteFilePath );
//                                }
//
//                                try {
//                                    fltDptrDateSimplePars = simpleDateFormat.format(fltDptrDate1);
//                                } catch( Exception ex){
//                                    System.out.println("While Formating using SimpleDataFormat:" + fltDptrDate1 + "file name" + absoluteFilePath );
//                                }
//
//                                try {
//                                    fltDptrDate = simpleDateFormat.parse(fltDptrDateSimplePars);
//                                } catch( Exception ex){
//                                    System.out.println("While parsing using SimpleDataFormat:" + fltDptrDateSimplePars + "file name" + absoluteFilePath );
//                                }*/
//
//                                try {
//                                    //System.out.println("Flight Departure date :"  + ft.getDepartureDate() + "File Name " + absoluteFilePath);
//                                    //System.out.println("Flight Departure ToDate :"  + ft.getDepartureDate().toDate());
//                                    fltDptrDate = simpleDateFormat.parse(simpleDateFormat.format(ft.getDepartureDate().toDate()));
//                                } catch (ParseException prsExcep) {
//                                    //LOGGER.info("Exception in parsing :");
//                                    //prsExcep.printStackTrace();
//                                    //System.out.println("Exception in parsing :" + absoluteFilePath );
//                                    //System.exit(0);
//                                    continue;
//                                }
//                                for (InfluenceOutput infl : ft.getInfluence()) {
//                                    //Skip negative influence period
//                                    if (infl.getInfluencePeriod() < 0) {
//                                        continue;
//                                    }
//                                    int flightId = ft.getFlightId();
//                                    char cabinCode = infl.getCabinCode().charAt(0);
//                                    //Long flightKey = new Long(flightId )* 10000000000L + (new Long(simpleDateFormat.format(fltDptrDate))*100L) + cabinCode;
//                                    Long flightKey = (new Long(simpleDateFormat.format(fltDptrDate))*100000000L) + new Long(flightId)*100L + cabinCode;
//                                    int mwpFcst = (int) (infl.getMaxWtpDemand().getForecast() *10);
//                                    FcResult fcstResult = new FcResult((int)(infl.getMaxWtpDemand().getPureForecast() *10),mwpFcst,mwpFcst,(int) (infl.getMaxWtpDemand().getRemainingDemand() *10),mwpFcst + 50,mwpFcst + 100,mwpFcst + 150);
//                                    if(fcstOutput == null ){
//
//                                        fcstOutput = new FcOutput(ft.getOrigin().toString(),ft.getDestination().toString(),fltDptrDate.getTime(),ft.getForecastId(),ft.getDayOfWeek(),PoolCode.valueOf(ft.getPoolCode().toString()).ordinal(), cabinCode,ft.getFlightId(),ft.getFlightNumber(),0);
//                                        fcstOutput.setFcstResult(infl.getForecastClass(),infl.getInfluencePeriod(), infl.getPointOfSale(),  LocalFlow.valueOf(infl.getLocalFlowIndicator().toString()).ordinal(),fcstResult);
//                                    }else{
//
//                                        if(flightKey.longValue() == fcstOutput.getKey().longValue()){
//                                            fcstOutput.setFcstResult(infl.getForecastClass(),infl.getInfluencePeriod(), infl.getPointOfSale(),  LocalFlow.valueOf(infl.getLocalFlowIndicator().toString()).ordinal(),fcstResult);
//                                        }else{
//
//                                           dataStreamer.addData(flightKey,fcstOutput);
//                                            fcstOutput = new FcOutput(ft.getOrigin().toString(),ft.getDestination().toString(),fltDptrDate.getTime(),ft.getForecastId(),ft.getDayOfWeek(),PoolCode.valueOf(ft.getPoolCode().toString()).ordinal(), cabinCode,ft.getFlightId(),ft.getFlightNumber(),0);
//                                            fcstOutput.setFcstResult(infl.getForecastClass(),infl.getInfluencePeriod(), infl.getPointOfSale(),  LocalFlow.valueOf(infl.getLocalFlowIndicator().toString()).ordinal(),fcstResult);
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    } catch (IOException ex){
//                        ex.printStackTrace();
//                    }
//                //});
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }catch(Exception exp){
//            exp.printStackTrace();
//        }
    }
}
