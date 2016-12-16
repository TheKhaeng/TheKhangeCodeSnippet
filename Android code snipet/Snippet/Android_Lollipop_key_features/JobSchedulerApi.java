/****************************************/
/** Created by TheKhaeng on 7/21/2016. **/
/****************************************/

JobInfo uploadJob =
  new JobInfo.Builder( idInt, serviceComponent )
    .setRequiiredNetworkCapabilities( JobInfo.NewworkType.ANY )
    .setPreiodic( 15 * DateUtils.HOURS_IN_MILLIS )
    // .setOverrideDeadline( 15 * DateUtils.MINUTES_IN_MILLIS ) // guarantee to run this job
    .setRequiresChargin( true )
    .build();
