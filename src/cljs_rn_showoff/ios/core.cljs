(ns cljs-rn-showoff.ios.core
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [cljs-rn-showoff.events]
            [cljs-rn-showoff.subs]
            [cljs-rn-showoff.shared.ui :as ui]
            [cljs-rn-showoff.showoffs.re-natal-default :as re-natal-default]
            ))

(def ReactNative (js/require "react-native"))
(def app-registry (.-AppRegistry ReactNative))

(defn app-root []
  (let [greeting (subscribe [:get-greeting])]
    (fn []
      [ui/swiper {:show-buttons true}
       [re-natal-default/render]
       [ui/view {:style {:flex-direction "column"
                         :margin         40
                         :align-items    "center"}}
        [ui/text {:style {:font-size     30
                          :font-weight   "100"
                          :margin-bottom 20
                          :color         "black"
                          :text-align    "center"}}
         "Page 2"]
        ]
       [ui/view {:style {:flex-direction "column"
                         :margin         40
                         :align-items    "center"}}
        [ui/text {:style {:font-size     30
                          :font-weight   "100"
                          :margin-bottom 20
                          :color         "black"
                          :text-align    "center"}}
         "Page 3"]
        ]]
      )))

(defn init []
      (dispatch-sync [:initialize-db])
      (.registerComponent app-registry "CljsRnShowoff" #(r/reactify-component app-root)))
