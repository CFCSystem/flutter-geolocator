package com.baseflow.geolocator.location;

import java.util.Map;

public class LocationOptions {
  private final LocationAccuracy accuracy;
  private final long distanceFilter;
  private final long timeInterval;
  private final boolean useMSLAltitude;

  private LocationOptions(
      LocationAccuracy accuracy, long distanceFilter, long timeInterval, boolean useMSLAltitude) {
    this.accuracy = accuracy;
    this.distanceFilter = distanceFilter;
    this.timeInterval = timeInterval;
    this.useMSLAltitude = useMSLAltitude;
  }

  public static LocationOptions parseArguments(Map<String, Object> arguments) {
    if (arguments == null) {
      return new LocationOptions(LocationAccuracy.best, 0, 5000, false);
    }

    final Integer accuracy = (Integer) arguments.get("accuracy");
    final Integer distanceFilter = (Integer) arguments.get("distanceFilter");
    final Integer timeInterval = (Integer) arguments.get("timeInterval");
    final Boolean useMSLAltitude = (Boolean) arguments.get("useMSLAltitude");

    LocationAccuracy locationAccuracy = LocationAccuracy.best;

    return new LocationOptions(
        locationAccuracy,
        distanceFilter != null ? distanceFilter : 0,
        timeInterval != null ? timeInterval : 5000,
        useMSLAltitude != null && useMSLAltitude);
  }

  public LocationAccuracy getAccuracy() {
    return accuracy;
  }

  public long getDistanceFilter() {
    return distanceFilter;
  }

  public long getTimeInterval() {
    return timeInterval;
  }

  public boolean isUseMSLAltitude() {
    return useMSLAltitude;
  }
}
