(ns cljs-rn-showoff.showoffs.re-natal-default
  (:require [cljs-rn-showoff.shared.ui :as ui]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]))

(def logo-img (js/require "./images/cljs.png"))

(defn render []
  (let [greeting (subscribe [:get-greeting])]
    (fn []
      [ui/view {:style {:flex-direction "column"
                        :margin         40
                        :align-items    "center"}}
       [ui/text {:style {:font-size     30
                         :font-weight   "100"
                         :margin-bottom 20
                         :text-align    "center"}}
        @greeting]
       [ui/image {:source logo-img
                  :style  {:width         80
                           :height        80
                           :margin-bottom 30}}]
       [ui/touchable-highlight {:style    {:background-color "#999"
                                           :padding          10
                                           :border-radius    5}
                                :on-press #(ui/alert "HELLO!")}
        [ui/text {:style {:color       "white"
                          :text-align  "center"
                          :font-weight "bold"}}
         "press me"]]])))
