(ns bloggo.main.components.input)

(defn button [text on-click]
  [:button {:type :button
            :on-click on-click}
   text])
