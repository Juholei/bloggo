(ns bloggo.editor.views.components.button-bar
  (:require [bloggo.main.components.input :as input]))

(defn button-bar [bar-id content]
  [:ul {:id bar-id}
   (for [{:keys [text on-click]} content]
     ^{:key (str bar-id "-" text)}
     [:li
      [input/button text on-click]])])

