Adad Cordova plugin
====================
Adad ad service plugin for cordova, phonegap and ionic.<br/>

- Adad android SDK 5.1.1<br/>
- Cordova version >3.0<br/>

## Install plugin ##

### Cordova cli ###
https://cordova.apache.org/docs/en/edge/guide_cli_index.md.html#The%20Command-Line%20Interface - npm install -g cordova@6.0.0
```c
cordova plugin add adad-cordova-plugin
(when build error, use github url: cordova plugin add cordova plugin add https://github.com/vinoosir/adad-cordova-plugin)
```

### Phonegap build service (config.xml) ###
https://build.phonegap.com/ - Apps - [specific project] - Update code - Zip file including config.xml
```c
<gap:plugin name="adad-cordova-plugin" source="npm" />
```

### Construct2 ###
Download construct2 plugin<br>
http://vinoos.ir/help/plugins/adad.php


## Use Plugin ##

### 1.Initialize adad cordova plugin
initialize plugin after deviceready event <br />

```js
window.adad.initialize("YOUR?_APP_TOKEN_GOES_HERE");
```

### 2.Enable/disable ads

```js
window.adad.setEnabled(true);
```

### 3.Enable/disable test mode

```js
window.adad.setTestMode(true);
```

### 4.Add banner 

you can add the banner at the TOP/BOTTOM/XY of your app.
`windows.adad.Position` holds  positions const.

```js
window.adad.addBanner("YOUR?_BANNER_AD_CONTAINER_GOES_HERE", window.adad.Position.BOTTOM, 0, 0);
window.adad.addBanner("YOUR?_BANNER_AD_CONTAINER_GOES_HERE", window.adad.Position.TOP, 0, 0);
window.adad.addBanner("YOUR?_BANNER_AD_CONTAINER_GOES_HERE", window.adad.Position.XY, 10, 50);
```

### 5.Remove banner 

```js
window.adad.removeBanner();
```

###  6.Show fullscreen ad 
first prepare fullscreen ad.

```js
window.adad.prepareFullscreenBannerAd("ADD_YOUR_AD_CONTAINER_TOKEN_HERE");
```

for checking if fullscreen ad is ready add this code:

```js
window.adad.isFullscreenBannerReady();
```

to show fullscreen ad use `window.adad.showFullscreenBannerAd();`.

```js
window.adad.onFullscreenReady = function () {
	window.adad.showFullscreenBannerAd();
};
window.adad.onFullscreenNotReady = function () {
	alert('FullscreenBannerAd Not Ready.');
};
```

you can use this event:

```js
window.adad.FullscreenBannerAdClosed = function () {
	alert('FullscreenBannerAdClosed');
};
window.adad.FullscreenBannerAdError = function () {
	alert('FullscreenBannerAdError');
};
window.adad.FullscreenBannerAdLoaded = function () {
	alert('FullscreenBannerAdLoaded');
};
window.adad.FullscreenBannerAdShowed = function () {
	alert('FullscreenBannerAdShowed');
};
```

*dont use `window.adad.showFullscreenBannerAd();` in FullscreenBannerAdLoaded event.*

###  7.Show video ad
there is 3 different type of video ad in sdk.
first prepare video ad.

```js
window.adad.prepareClosableVideoAd("ADD_YOUR_AD_CONTAINER_TOKEN_HERE");
window.adad.prepareGeneralVideoAd("ADD_YOUR_AD_CONTAINER_TOKEN_HERE");
window.adad.prepareRewardVideoAd("ADD_YOUR_AD_CONTAINER_TOKEN_HERE");
```

for checking if video ad is ready add this code:

```js
window.adad.isClosableVideoAdReady();
window.adad.isGeneralVideoAdReady();
window.adad.isRewardVideoAdReady();
```

to show video ad use one of these commands:

```js
window.adad.showClosableVideoAd();
window.adad.showGeneralVideoAd();
window.adad.showRewardVideoAd();
```

```js
window.adad.onClosableVideoAdReady = function () {
	window.adad.showClosableVideoAd();
};
window.adad.onClosableVideoAdNotReady = function () {
	alert('Closable VideoAd Not Ready.');
};


window.adad.onGeneralVideoAdReady = function () {
	window.adad.showGeneralVideoAd();
};
window.adad.onGeneralVideoAdNotReady = function () {
	alert('General VideoAd Not Ready.');
};


window.adad.onRewardVideoAdReady = function () {
	window.adad.showRewardVideoAd();
};
window.adad.onRewardVideoAdNotReady = function () {
	alert('Reward VideoAd Not Ready.');
};
```

you can use this event:

```js
window.adad.ClosableVideoAdClosed = function () {
	alert('ClosableVideoAdClosed');
};
window.adad.ClosableVideoAdError = function () {
	alert('ClosableVideoAdError');
};
window.adad.ClosableVideoAdLoaded = function () {
	alert('ClosableVideoAdLoaded');
};
window.adad.ClosableVideoAdShowed = function () {
	alert('ClosableVideoAdShowed');
};
window.adad.ClosableVideoAdComplete = function () {
	alert('ClosableVideoAdComplete');
};
window.adad.ClosableVideoAdDestroy = function () {
	alert('ClosableVideoAdDestroy');
};
window.adad.ClosableVideoAdStart = function () {
	alert('ClosableVideoAdStart');
};


window.adad.GeneralVideoAdClosed = function () {
	alert('GeneralVideoAdClosed');
};
window.adad.GeneralVideoAdError = function () {
	alert('GeneralVideoAdError');
};
window.adad.GeneralVideoAdLoaded = function () {
	alert('GeneralVideoAdLoaded');
};
window.adad.GeneralVideoAdShowed = function () {
	alert('GeneralVideoAdShowed');
};
window.adad.GeneralVideoAdComplete = function () {
	alert('GeneralVideoAdComplete');
};
window.adad.GeneralVideoAdDestroy = function () {
	alert('GeneralVideoAdDestroy');
};
window.adad.GeneralVideoAdStart = function () {
	alert('GeneralVideoAdStart');
};


window.adad.RewardVideoAdClosed = function () {
	alert('RewardVideoAdClosed');
};
window.adad.RewardVideoAdError = function () {
	alert('RewardVideoAdError');
};
window.adad.RewardVideoAdLoaded = function () {
	alert('RewardVideoAdLoaded');
};
window.adad.RewardVideoAdShowed = function () {
	alert('RewardVideoAdShowed');
};
window.adad.RewardVideoAdComplete = function () {
	alert('RewardVideoAdComplete');
};
window.adad.RewardVideoAdDestroy = function () {
	alert('RewardVideoAdDestroy');
};
window.adad.RewardVideoAdStart = function () {
	alert('RewardVideoAdStart');
};
```

*dont use `window.adad.showClosableVideoAd();` in ClosableVideoAdLoaded event.*
*dont use `window.adad.showGeneralVideoAd();` in GeneralVideoAdLoaded event.*
*dont use `window.adad.showRewardVideoAd();` in RewardVideoAdLoaded event.*

## Examples ##
<a href="https://github.com/vinoosir/adad-cordova-plugin/blob/master/example/index.html">Click to see!</a><br>

## Test ##
You can run following test apk:<br>
http://s9.picofile.com/file/8334784268/Adad.apk.html


# Credite and donate #
Created by: Milad Mohammadi Rezagah<br>
Email: Rezagah.Milad@Gmail.com<br>
Web: http://vinoos.ir<br>
Telegram ID: @MilaDesign<br>
donate: http://vinoos.ir/donate.php