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
(when build error, use github url: cordova plugin add cordova plugin add https://github.com/miladesign/adad-cordova-plugin)
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

    window.adad.initialize("YOUR‌_APP_TOKEN_GOES_HERE");
	
### 2.Enable/disable ads

    window.adad.setEnabled(true);
	
### 3.Enable/disable test mode

    window.adad.setTestMode(true);
    
### 4.Add banner 

you can add the banner at the TOP/BOTTOM/XY of your app.
windows.adad.Position holds  positions const.

    window.adad.addBanner("YOUR‌_BANNER_AD_CONTAINER_GOES_HERE", window.adad.Position.BOTTOM, 0, 0);
    window.adad.addBanner("YOUR‌_BANNER_AD_CONTAINER_GOES_HERE", window.adad.Position.TOP, 0, 0);
    window.adad.addBanner("YOUR‌_BANNER_AD_CONTAINER_GOES_HERE", window.adad.Position.XY, 10, 50);

### 5.Remove banner 

    window.adad.removeBanner();

###  6.Show fullscreen ad 
prepare fullscreen ad ,and then use isFullscreenBannerAdReady() to check if ad ready then show it.

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