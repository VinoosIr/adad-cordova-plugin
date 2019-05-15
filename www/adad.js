module.exports = {
	Position: {
        TOP: 0,
        BOTTOM: 1,
		XY: 2
    },
    initialize: function(token) {
        cordova.exec(
			null,
			null,
            'CordovaAdad',
            'initialize',
            [ token ]
        ); 
    },
    addBanner: function(token, position, x, y) {
        cordova.exec(
			null,
			null,
            'CordovaAdad',
            'addBanner',
            [ token, position, x, y ]
        ); 
    },
    removeBanner: function() {
        cordova.exec(
			null,
			null,
            'CordovaAdad',
            'removeBanner',
            []
        ); 
    },
    setEnabled: function(enabled) {
        cordova.exec(
			null,
			null,
            'CordovaAdad',
            'setEnabled',
            [ enabled ]
        ); 
    },
    setTestMode: function(testMode) {
        cordova.exec(
			null,
			null,
            'CordovaAdad',
            'setTestMode',
            [ testMode ]
        ); 
    },
    prepareFullscreenBannerAd: function (token) {
        var self = this;
        cordova.exec(
            function (result) {
                if (typeof result == "string") {
                    if (result == "FullscreenBannerAdClosed") {
                        if (self.FullscreenBannerAdClosed) {
                            self.FullscreenBannerAdClosed();
                        }
                    }
                    if (result == "FullscreenBannerAdError") {
                        if (self.FullscreenBannerAdError) {
                            self.FullscreenBannerAdError();
                        }
                    }
                    if (result == "FullscreenBannerAdLoaded") {
                        if (self.FullscreenBannerAdLoaded) {
                            self.FullscreenBannerAdLoaded();
                        }
                    }
                    if (result == "FullscreenBannerAdShowed") {
                        if (self.FullscreenBannerAdShowed) {
                            self.FullscreenBannerAdShowed();
                        }
                    }
                }
            },
            null,
            'CordovaAdad',
            'prepareFullscreenBannerAd',
            [ token ]
        );
    },
    isFullscreenBannerReady: function () {
        var self = this;
        cordova.exec(
            function (result) {
                if (typeof result == "string") {
					if (result == "onFullscreenReady") {
						if (self.onFullscreenReady) {
                            self.onFullscreenReady();
                        }
                    }
                    if (result == "onFullscreenNotReady") {
						if (self.onFullscreenNotReady) {
                            self.onFullscreenNotReady();
                        }
                    }
                }
            },
            null,
            'CordovaAdad',
            'isFullscreenBannerReady',
            []
        );
    },
    showFullscreenBannerAd: function () {
        cordova.exec(
            null,
            null,
            'CordovaAdad',
            'showFullscreenBannerAd',
            []
        );
    },
    prepareClosableVideoAd: function (token) {
        var self = this;
        cordova.exec(
            function (result) {
                if (typeof result == "string") {
					if (result == "ClosableVideoAdClosed") {
                        if (self.ClosableVideoAdClosed) {
                            self.ClosableVideoAdClosed();
                        }
                    }
                    if (result == "ClosableVideoAdError") {
                        if (self.ClosableVideoAdError) {
                            self.ClosableVideoAdError();
                        }
                    }
                    if (result == "ClosableVideoAdLoaded") {
                        if (self.ClosableVideoAdLoaded) {
                            self.ClosableVideoAdLoaded();
                        }
                    }
                    if (result == "ClosableVideoAdShowed") {
                        if (self.ClosableVideoAdShowed) {
                            self.ClosableVideoAdShowed();
                        }
                    }
                    if (result == "ClosableVideoAdComplete") {
                        if (self.ClosableVideoAdComplete) {
                            self.ClosableVideoAdComplete();
                        }
                    }
                    if (result == "ClosableVideoAdDestroy") {
                        if (self.ClosableVideoAdDestroy) {
                            self.ClosableVideoAdDestroy();
                        }
                    }
                    if (result == "ClosableVideoAdStart") {
                        if (self.ClosableVideoAdStart) {
                            self.ClosableVideoAdStart();
                        }
                    }
                }
            },
            null,
            'CordovaAdad',
            'prepareClosableVideoAd',
            [ token ]
        );
    },
    showClosableVideoAd: function () {
        cordova.exec(
            null,
            null,
            'CordovaAdad',
            'showClosableVideoAd',
            []
        );
    },
    prepareGeneralVideoAd: function (token) {
        var self = this;
        cordova.exec(
            function (result) {
                if (typeof result == "string") {
					if (result == "GeneralVideoAdClosed") {
                        if (self.GeneralVideoAdClosed) {
                            self.GeneralVideoAdClosed();
                        }
                    }
                    if (result == "GeneralVideoAdError") {
                        if (self.GeneralVideoAdError) {
                            self.GeneralVideoAdError();
                        }
                    }
                    if (result == "GeneralVideoAdLoaded") {
                        if (self.GeneralVideoAdLoaded) {
                            self.GeneralVideoAdLoaded();
                        }
                    }
                    if (result == "GeneralVideoAdShowed") {
                        if (self.GeneralVideoAdShowed) {
                            self.GeneralVideoAdShowed();
                        }
                    }
                    if (result == "GeneralVideoAdComplete") {
                        if (self.GeneralVideoAdComplete) {
                            self.GeneralVideoAdComplete();
                        }
                    }
                    if (result == "GeneralVideoAdDestroy") {
                        if (self.GeneralVideoAdDestroy) {
                            self.GeneralVideoAdDestroy();
                        }
                    }
                    if (result == "GeneralVideoAdStart") {
                        if (self.GeneralVideoAdStart) {
                            self.GeneralVideoAdStart();
                        }
                    }
                }
            },
            null,
            'CordovaAdad',
            'prepareGeneralVideoAd',
            [ token ]
        );
    },
    showGeneralVideoAd: function () {
        cordova.exec(
            null,
            null,
            'CordovaAdad',
            'showGeneralVideoAd',
            []
        );
    },
    prepareRewardVideoAd: function (token) {
        var self = this;
        cordova.exec(
            function (result) {
                if (typeof result == "string") {
					if (result == "RewardVideoAdClosed") {
                        if (self.RewardVideoAdClosed) {
                            self.RewardVideoAdClosed();
                        }
                    }
                    if (result == "RewardVideoAdError") {
                        if (self.RewardVideoAdError) {
                            self.RewardVideoAdError();
                        }
                    }
                    if (result == "RewardVideoAdLoaded") {
                        if (self.RewardVideoAdLoaded) {
                            self.RewardVideoAdLoaded();
                        }
                    }
                    if (result == "RewardVideoAdShowed") {
                        if (self.RewardVideoAdShowed) {
                            self.RewardVideoAdShowed();
                        }
                    }
                    if (result == "RewardVideoAdComplete") {
                        if (self.RewardVideoAdComplete) {
                            self.RewardVideoAdComplete();
                        }
                    }
                    if (result == "RewardVideoAdDestroy") {
                        if (self.RewardVideoAdDestroy) {
                            self.RewardVideoAdDestroy();
                        }
                    }
                    if (result == "RewardVideoAdStart") {
                        if (self.RewardVideoAdStart) {
                            self.RewardVideoAdStart();
                        }
                    }
                }
            },
            null,
            'CordovaAdad',
            'prepareRewardVideoAd',
            [ token ]
        );
    },
    showRewardVideoAd: function () {
        cordova.exec(
            null,
            null,
            'CordovaAdad',
            'showRewardVideoAd',
            []
        );
    },
    isClosableVideoAdReady: function () {
        var self = this;
        cordova.exec(
            function (result) {
                if (typeof result == "string") {
					if (result == "onClosableVideoAdReady") {
						if (self.onClosableVideoAdReady) {
                            self.onClosableVideoAdReady();
                        }
                    }
                    if (result == "onClosableVideoAdNotReady") {
						if (self.onClosableVideoAdNotReady) {
                            self.onClosableVideoAdNotReady();
                        }
                    }
                }
            },
            null,
            'CordovaAdad',
            'isClosableVideoAdReady',
            []
        );
    },
    isGeneralVideoAdReady: function () {
        var self = this;
        cordova.exec(
            function (result) {
                if (typeof result == "string") {
					if (result == "onGeneralVideoAdReady") {
						if (self.onGeneralVideoAdReady) {
                            self.onGeneralVideoAdReady();
                        }
                    }
                    if (result == "onGeneralVideoAdNotReady") {
						if (self.onGeneralVideoAdNotReady) {
                            self.onGeneralVideoAdNotReady();
                        }
                    }
                }
            },
            null,
            'CordovaAdad',
            'isGeneralVideoAdReady',
            []
        );
    },
    isRewardVideoAdReady: function () {
        var self = this;
        cordova.exec(
            function (result) {
                if (typeof result == "string") {
                    if (result == "onRewardVideoAdReady") {
						if (self.onRewardVideoAdReady) {
                            self.onRewardVideoAdReady();
                        }
                    }
                    if (result == "onRewardVideoAdNotReady") {
						if (self.onRewardVideoAdNotReady) {
                            self.onRewardVideoAdNotReady();
                        }
                    }
                }
            },
            null,
            'CordovaAdad',
            'isRewardVideoAdReady',
            []
        );
    },
    FullscreenBannerAdClosed: null,
    FullscreenBannerAdError: null,
    FullscreenBannerAdLoaded: null,
    FullscreenBannerAdShowed: null,
    ClosableVideoAdClosed: null,
    ClosableVideoAdError: null,
    ClosableVideoAdLoaded: null,
    ClosableVideoAdShowed: null,
    ClosableVideoAdComplete: null,
    ClosableVideoAdDestroy: null,
    ClosableVideoAdStart: null,
    GeneralVideoAdClosed: null,
    GeneralVideoAdError: null,
    GeneralVideoAdLoaded: null,
    GeneralVideoAdShowed: null,
    GeneralVideoAdComplete: null,
    GeneralVideoAdDestroy: null,
    GeneralVideoAdStart: null,
    RewardVideoAdClosed: null,
    RewardVideoAdError: null,
    RewardVideoAdLoaded: null,
    RewardVideoAdShowed: null,
    RewardVideoAdComplete: null,
    RewardVideoAdDestroy: null,
    RewardVideoAdStart: null,
    onFullscreenReady: null,
    onFullscreenNotReady: null,
    onClosableVideoAdReady: null,
    onClosableVideoAdNotReady: null,
    onGeneralVideoAdReady: null,
    onGeneralVideoAdNotReady: null,
    onRewardVideoAdReady: null,
    onRewardVideoAdNotReady: null
};