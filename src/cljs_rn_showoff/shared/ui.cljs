(ns cljs-rn-showoff.shared.ui
  (:require [reagent.core :as r]))

(set! js/React (js/require "react-native"))

(def app-registry
  (.-AppRegistry js/React))


;; Basic functions

(defn alert [title]
  (.alert (.-Alert js/React) title))



;; Basic components

(def view
  (r/adapt-react-class (.-View js/React)))
(def scroll
  (r/adapt-react-class (.-ScrollView js/React)))
(def image
  (r/adapt-react-class (.-Image js/React)))
(def progress-bar
  (r/adapt-react-class (.-ProgressBarAndroid js/React)))
(def text
  (r/adapt-react-class (.-Text js/React)))
(def input
  (r/adapt-react-class (.-TextInput js/React)))

(def touchable-highlight
  (r/adapt-react-class (.-TouchableHighlight js/React)))

(def touchable
  (r/adapt-react-class (.-TouchableWithoutFeedback js/React)))

(def linking
  (.-Linking js/React))


;; Imported components

(def Swiper
  (js/require "react-native-swiper"))
(def swiper
  (r/adapt-react-class Swiper))
