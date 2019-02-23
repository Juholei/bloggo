(ns bloggo.editor.views.components.button-bar)

(defn button [button-data]
  [:button {:type :button
            :on-click (:on-click button-data)}
   (:text button-data)])

(defn button-bar [bar-id content]
  [:ul {:id bar-id}
   (for [button-content content]
     ^{:key (str bar-id "-" (:text button-content))}
     [:li
      [button button-content]])])

