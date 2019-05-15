package miladesign.cordova;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ir.adad.ad.AdadAdListener;
import ir.adad.banner.AdadBannerAd;
import ir.adad.core.Adad;
import ir.adad.fullscreen.AdadFullscreenBannerAd;
//import ir.adad.notification.AdadNotificationAd;
import ir.adad.video.AdadVideoAd;
import ir.adad.video.AdadVideoAdListener;

public class CordovaAdad extends CordovaPlugin {
	private static final String TAG = "CordovaAdad";
	private static Activity mActivity = null;
	public CordovaInterface cordova = null;
	private FrameLayout bannerLayout;
	private static final int POSITION_TOP = 0;
	private static final int POSITION_BOTTOM = 1;
	private static final int POSITION_XY = 2;
	
	@Override
	public void initialize(CordovaInterface initCordova, CordovaWebView webView) {
		 Log.e (TAG, "initialize");
		 cordova = initCordova;
		 super.initialize (cordova, webView);
	}
	
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext CallbackContext) throws JSONException {
		if (action.equals("initialize")) {
			setup(args, CallbackContext);
			return true;
		}
		if (action.equals("addBanner")) {
			addBanner(args, CallbackContext);
			return true;
		}
		if (action.equals("removeBanner")) {
			removeBanner(CallbackContext);
			return true;
		}
		if (action.equals("setEnabled")) {
			setEnabled(args, CallbackContext);
			return true;
		}
		if (action.equals("setTestMode")) {
			setTestMode(args, CallbackContext);
		    return true;
		}
		if (action.equals("prepareFullscreenBannerAd")) {
			prepareFullscreenBannerAd(args, CallbackContext);
		    return true;
		}
		if (action.equals("showFullscreenBannerAd")) {
			showFullscreenBannerAd(args, CallbackContext);
		    return true;
		}
		if (action.equals("prepareClosableVideoAd")) {
			prepareClosableVideoAd(args, CallbackContext);
		    return true;
		}
		if (action.equals("showClosableVideoAd")) {
			showClosableVideoAd(args, CallbackContext);
		    return true;
		}
		if (action.equals("prepareGeneralVideoAd")) {
			prepareGeneralVideoAd(args, CallbackContext);
		    return true;
		}
		if (action.equals("showGeneralVideoAd")) {
			showGeneralVideoAd(args, CallbackContext);
		    return true;
		}
		if (action.equals("prepareRewardVideoAd")) {
			prepareRewardVideoAd(args, CallbackContext);
		    return true;
		}
		if (action.equals("showRewardVideoAd")) {
			showRewardVideoAd(args, CallbackContext);
		    return true;
		}
		if (action.equals("isFullscreenBannerReady")) {
			isFullscreenBannerReady(CallbackContext);
		    return true;
		}
		if (action.equals("isClosableVideoAdReady")) {
			isClosableVideoAdReady(CallbackContext);
		    return true;
		}
		if (action.equals("isGeneralVideoAdReady")) {
			isGeneralVideoAdReady(CallbackContext);
		    return true;
		}
		if (action.equals("isRewardVideoAdReady")) {
			isRewardVideoAdReady(CallbackContext);
		    return true;
		}
		/*if (action.equals("prepareNotificationAd")) {
			prepareNotificationAd(args, CallbackContext);
		    return true;
		}*/
	    return false;
	}
	
	private void setup(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		final String AppKey = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			public void run() {
				mActivity = cordova.getActivity();
			    Adad.initialize(AppKey);
			    callbackContext.success();
			}
	    });
	}

	private void addBanner(final JSONArray args, final CallbackContext callbackContext) throws JSONException {
		final String adContainerToken = args.getString(0);
		final int position = args.getInt(1);
		final int x = args.getInt(2);
		final int y = args.getInt(3);
		
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if (bannerLayout != null) {
					removeBanner(callbackContext);
				}
				bannerLayout = new FrameLayout(mActivity);
			    FrameLayout.LayoutParams fLayoutParams = new FrameLayout.LayoutParams(-2, -2);
			    switch (position) {
				    case POSITION_TOP:
				    	fLayoutParams.gravity = Gravity.TOP|Gravity.CENTER;
				    	break;
				    case POSITION_BOTTOM:
				    	fLayoutParams.gravity = Gravity.BOTTOM|Gravity.CENTER;
				    case POSITION_XY:
				    	fLayoutParams.leftMargin = x;
				    	fLayoutParams.topMargin = y;
			    }
			    bannerLayout.setLayoutParams(fLayoutParams);
			    ((ViewGroup) getParentGroup().getParent()).addView(bannerLayout, 1);
			    AdadBannerAd banner = new AdadBannerAd(cordova.getActivity().getApplicationContext());
		    	banner.setAdContainerToken(adContainerToken);
				bannerLayout.addView(banner);
				callbackContext.success();
			}
		});
	}
	
	private void removeBanner(CallbackContext callbackContext) {
		if (bannerLayout == null)
		      return;
	    if (mActivity != null) {
	    	mActivity.runOnUiThread(new Runnable() {
	        public void run() {
	        	ViewGroup viewGroup;
        		if (((viewGroup = getParentGroup()) != null) && ((viewGroup instanceof ViewGroup)) && (((ViewGroup)viewGroup.getParent()).getChildAt(1) != null))
        			((ViewGroup)viewGroup.getParent()).removeViewAt(1);
	        	}
	    	});
	    	callbackContext.success();
	    }
	}
	
	private void setEnabled(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		final boolean enabled = args.getBoolean(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Adad.setEnabled(enabled);
				callbackContext.success();
			}
		});
	}
	
	private void setTestMode(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		final boolean testMode = args.getBoolean(0);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Adad.setTestMode(testMode);
				callbackContext.success();
			}
		});
	}
	
	private void prepareFullscreenBannerAd(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		final String adContainerToken = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable(){
			@Override
			public void run() {
				AdadFullscreenBannerAd.prepare(mActivity, adContainerToken, new AdadAdListener(){
					@Override
					public void onActionOccurred(int code) {
						
					}

					@Override
					public void onClosed() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "FullscreenBannerAdClosed");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onError(int code, String message) {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "FullscreenBannerAdError");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onLoaded() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "FullscreenBannerAdLoaded");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onShowed() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "FullscreenBannerAdShowed");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}
				});
			}
		});
	}
	
	private void showFullscreenBannerAd(JSONArray args, CallbackContext callbackContext) throws JSONException {
		cordova.getActivity().runOnUiThread(new Runnable(){
			@Override
			public void run() {
				AdadFullscreenBannerAd.show(mActivity);
			}
		});
	}
	
	private void prepareClosableVideoAd(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		final String adContainerToken = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable(){
			@Override
			public void run() {
				AdadVideoAd.prepareClosableVideoAd(mActivity, adContainerToken, new AdadVideoAdListener(){
					@Override
					public void onActionOccurred(int code) {
						
					}

					@Override
					public void onClosed() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "ClosableVideoAdClosed");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onError(int code, String message) {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "ClosableVideoAdError");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onLoaded() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "ClosableVideoAdLoaded");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onShowed() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "ClosableVideoAdShowed");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onVideoAdComplete() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "ClosableVideoAdComplete");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onVideoAdDestroy() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "ClosableVideoAdDestroy");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onVideoAdStart() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "ClosableVideoAdStart");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}
				});
			}
		});
	}
	
	private void showClosableVideoAd(JSONArray args, CallbackContext callbackContext) throws JSONException {
		cordova.getActivity().runOnUiThread(new Runnable(){
			@Override
			public void run() {
				AdadVideoAd.showClosableVideoAd(mActivity);
			}
		});
	}

	private void prepareGeneralVideoAd(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		final String adContainerToken = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable(){
			@Override
			public void run() {
				AdadVideoAd.prepareGeneralVideoAd(mActivity, adContainerToken, new AdadVideoAdListener(){
					@Override
					public void onActionOccurred(int code) {
						
					}

					@Override
					public void onClosed() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "GeneralVideoAdClosed");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onError(int code, String message) {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "GeneralVideoAdError");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onLoaded() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "GeneralVideoAdLoaded");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onShowed() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "GeneralVideoAdShowed");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onVideoAdComplete() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "GeneralVideoAdComplete");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onVideoAdDestroy() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "GeneralVideoAdDestroy");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onVideoAdStart() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "GeneralVideoAdStart");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}
				});
			}
		});
	}
	
	private void showGeneralVideoAd(JSONArray args, CallbackContext callbackContext) throws JSONException {
		cordova.getActivity().runOnUiThread(new Runnable(){
			@Override
			public void run() {
				AdadVideoAd.showGeneralVideoAd(mActivity);
			}
		});
	}

	private void prepareRewardVideoAd(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		final String adContainerToken = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable(){
			@Override
			public void run() {
				AdadVideoAd.prepareRewardVideoAd(mActivity, adContainerToken, new AdadVideoAdListener(){
					@Override
					public void onActionOccurred(int code) {
						
					}

					@Override
					public void onClosed() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "RewardVideoAdClosed");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onError(int code, String message) {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "RewardVideoAdError");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onLoaded() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "RewardVideoAdLoaded");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onShowed() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "RewardVideoAdShowed");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onVideoAdComplete() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "RewardVideoAdComplete");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onVideoAdDestroy() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "RewardVideoAdDestroy");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}

					@Override
					public void onVideoAdStart() {
						PluginResult pr = new PluginResult(PluginResult.Status.OK, "RewardVideoAdStart");
						pr.setKeepCallback(true);
						callbackContext.sendPluginResult(pr);
					}
				});
			}
		});
	}
	
	private void showRewardVideoAd(JSONArray args, CallbackContext callbackContext) throws JSONException {
		cordova.getActivity().runOnUiThread(new Runnable(){
			@Override
			public void run() {
				AdadVideoAd.showRewardVideoAd(mActivity);
			}
		});
	}
	
	private void isFullscreenBannerReady(final CallbackContext callbackContext) {
		cordova.getActivity().runOnUiThread(new Runnable(){
			@Override
			public void run() {
				boolean isReady = AdadFullscreenBannerAd.isReady();
				PluginResult pr;
			    if (isReady) {
			    	pr = new PluginResult(PluginResult.Status.OK, "onFullscreenReady");
			    } else {
			    	pr = new PluginResult(PluginResult.Status.OK, "onFullscreenNotReady");
			    }
			    pr.setKeepCallback(true);
			    callbackContext.sendPluginResult(pr);
			}
		});
	}
	
	private void isClosableVideoAdReady(final CallbackContext callbackContext) {
		cordova.getActivity().runOnUiThread(new Runnable(){
			@Override
			public void run() {
				boolean isReady = AdadVideoAd.isClosableVideoAdReady();
				PluginResult pr;
			    if (isReady) {
			    	pr = new PluginResult(PluginResult.Status.OK, "onClosableVideoAdReady");
			    } else {
			    	pr = new PluginResult(PluginResult.Status.OK, "onClosableVideoAdNotReady");
			    }
			    pr.setKeepCallback(true);
			    callbackContext.sendPluginResult(pr);
			}
		});
	}
	
	private void isGeneralVideoAdReady(final CallbackContext callbackContext) {
		cordova.getActivity().runOnUiThread(new Runnable(){
			@Override
			public void run() {
				boolean isReady = AdadVideoAd.isGeneralVideoAdReady();
				PluginResult pr;
			    if (isReady) {
			    	pr = new PluginResult(PluginResult.Status.OK, "onGeneralVideoAdReady");
			    } else {
			    	pr = new PluginResult(PluginResult.Status.OK, "onGeneralVideoAdNotReady");
			    }
			    pr.setKeepCallback(true);
			    callbackContext.sendPluginResult(pr);
			}
		});
	}
	
	private void isRewardVideoAdReady(final CallbackContext callbackContext) {
		cordova.getActivity().runOnUiThread(new Runnable(){
			@Override
			public void run() {
				boolean isReady = AdadVideoAd.isRewardVideoAdReady();
				PluginResult pr;
			    if (isReady) {
			    	pr = new PluginResult(PluginResult.Status.OK, "onRewardVideoAdReady");
			    } else {
			    	pr = new PluginResult(PluginResult.Status.OK, "onRewardVideoAdNotReady");
			    }
			    pr.setKeepCallback(true);
			    callbackContext.sendPluginResult(pr);
			}
		});
	}
	
	/*private void prepareNotificationAd(JSONArray args, final CallbackContext callbackContext) throws JSONException {
		final String adContainerToken = args.getString(0);
		cordova.getActivity().runOnUiThread(new Runnable(){
			@Override
			public void run() {
				AdadNotificationAd.prepare(mActivity, adContainerToken);
			}
		});
	}*/
	
	private ViewGroup getParentGroup() {
	    try {
	      return (ViewGroup)this.webView.getClass().getMethod("getView", new Class[0]).invoke(this.webView, new Object[0]);
	    } catch (Exception ex) {
	    	try {
	    		return (ViewGroup)this.webView.getClass().getMethod("getParent", new Class[0]).invoke(this.webView, new Object[0]);
	    	} catch (Exception e) {
	    		e.printStackTrace(); 
	        }
	    }
	    return null;
	}
}