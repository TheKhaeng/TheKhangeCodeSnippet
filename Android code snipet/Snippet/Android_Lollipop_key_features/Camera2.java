/****************************************/
/** Created by TheKhaeng on 7/21/2016. **/
/****************************************/

______________________________________________________________________________
// [ Overview ]

// https://spectrastudy.com/wp-content/uploads/2015/03/Camera2-pipeline.jpg
// Attach surface to CameraDevice. Each surface can be a destination for
// a stream of image buffers, and you can pass request(asynchronously) through
// the CaptureSession. Each request will be converted into "one result object".

// - CameraManager
// - CameraDevice
// - CaptureSession
// - CaptureRequest
// - CaptureResult

// CameraManager: you need to detect camera hardware or get the detail of camera


// [ Types of Surfaces ]
// - TextureView --> for previewing
// - MediaRecorder --> for recording a video
// - MediaCodec
// - ImageReader
// - RenderScriptAllocation --> Allocation for YUV processing

// [ Step ]
// 1. Opening the camera
// 2. Creating Surfaces
// 3. Creating CaptureSesion
// 4. Creating CaptureRequest
// 5. Submit request

android.hardware.camera2 //package name

______________________________________________________________________________
// 1. Opening the camera

mCameraManager =
  ( CameraManager )getSystemService( Context.CAMERA_SERVICE );

mCameraManager.openCamera( id , new StateListener() {
  @Override
  public void onOpened( CameraDevice cameraDevice ){
    // a representation of a single camera.
    mCameraDevice = cameraDevice;
    ...
  }
  ...
})
```

______________________________________________________________________________
// 2. Creating Surfaces

The size of surface is important

CameraCharacteristics characteristics =
  mCameraManager.getCameraCharacteristics("0");

// get the available stream configurations that the camera support
// by Scalar stream configuration map.
SreamConfigurationMap configs = characteristics.get(
  CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP
);
Size[] sizes = configs.getOutputSizes( ImageFormat.JPEG );

ImageReader mImageReader = ImageReader.newInstance(
                            sizes[0].getWidth(),
                            sizes[0].getHeight(),
                            ImageeFormat.JPEG,
                            2);
Surface jpegCaptureSurface = mImageReader.getSurface();

List<Surface> surfaces = new ArrayList<Surface>();
List<Surface> surfaces = new ArrayList<Surface>();
surfaces.add( jpegCaptureSurface );

______________________________________________________________________________
// 3. Creating CaptureSesion

// require several hundred milliseconds.
mCameraDevice.createCaptureSession( surfaces,
  new StateListener(){
    @Override
    public void onConfigured( CameraCaptureSession session ){
      mCameraCaptureSession = session;
    }
  }, null);

______________________________________________________________________________
// 4. Creating CaptureRequest

// TEMPLATE_PREVIEW
// TEMPLATE_RECORD
// TEMPLATE_STILL_CAPTURE
// TEMPLATE_VIDEO_SNAPSHOT

captureRequestBuilder = mCameraDevice.createCaptureRequest(
  CameraDevice.TEMPLATE_STILL_CAPTURE
);
captureRequestBuilder.addTarget( jpegCaptureSurface );
// white balance
captureRequestBuilder.set( CaptureRequest.CONTROL_AWB_MODE,
              CaptureRequest.CONTROL_AWB_MODE_INCANDESCENT )
// Effect
captureRequestBuilder.set( CaptureRequest.CONTROL_EFFECT_MODE,
              CaptureRequest.CONTROL_EFFECT_MODE_SEPIA )
// Flash
captureRequestBuilder.set( CaptureRequest.FLASH_MODE,
              CaptureRequest.FLASH_MODE_SINGLE )
// Jpeg capture request
captureRequest = captureRequestBuilder.build();

______________________________________________________________________________
// 5. Submit request
// - capture: for 1 image
// - setRepeatingRequest: for capture continuously

mCameraCaptureSession.capture( captureRequest,
  new CaptureListener(){
    @Override
    public void onCaptureStarted(
      CameraCaptureSession session,
      CaptureRequest request, long timestamp){
        ...
    },
    @Override
    public void onCaptureCompleted(
      CameraCaptureSession session,
      CaptureRequest request,
      TotalCaptureResult result){
        ...
    }, null);
