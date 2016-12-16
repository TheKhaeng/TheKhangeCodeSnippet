/****************************************/
/** Created by TheKhaeng on 7/17/2016. **/
/****************************************/
______________________________________________________________________________

// Launchingn caption settings
// Settings > Accessibility > caption
startActivityForIntent( new Intentt(
  Settings.ACTION_CAPTIONING_SETTINGS ));

------------------------------------------------------------------------------

// WebVTT(.vtt): The Web Video Text Tracks Format
WEBVTT
Kind: captions
Language: en
1
00:11.000 --> 00:13.000
[Roger Bingham]
We are in New York City
2
00:13.000 --> 00:16.000
[Roger Bingham]
We’re actually at the Lucern Hotel, just down the street
3
00:16.000 --> 00:18.000
[Roger Bingham]
from the American Museum of Natural History

------------------------------------------------------------------------------

// Add local source for English sub
mVideoView.addSubtitileSource(
  getResource().openRawResource( R.raw.subs_en_vtt ),
  MediaFormat.createSuubtitileFormat( "text/vtt",
    Locale.ENGLISH.getLanguage()
  )
);

// Add local source for French sub
mVideoView.addSubtitileSource(
  getResource().openRawResource( R.raw.subs_en_vtt ),
  MediaFormat.createSuubtitileFormat( "text/vtt",
    Locale.FRENCH.getLanguage()
  )
);
______________________________________________________________________________
