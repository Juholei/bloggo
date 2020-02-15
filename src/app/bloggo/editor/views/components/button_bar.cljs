(ns bloggo.editor.views.components.button-bar
  (:require [bloggo.main.components.button :refer [button]]))

(defn button-bar [bar-id content]
  [:ul {:id bar-id}
   (for [{:keys [text on-click]} content]
     ^{:key (str bar-id "-" text)}
     [:li
      [button text on-click]])])

