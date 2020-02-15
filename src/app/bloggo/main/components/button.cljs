(ns bloggo.main.components.button)

(defn button [text on-click]
  [:button {:type :button
            :on-click on-click}
   text])
