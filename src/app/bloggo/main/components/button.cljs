(ns bloggo.main.components.button)

(defn button [text on-click]
  [:button {:class ["bg-blue-500"
                    "hover:bg-blue-700"
                    "text-white"
                    "font-bold"
                    "py-2"
                    "px-4"
                    "rounded"
                    "my-2"
                    "mx-4"]
            :type :button
            :on-click on-click}
   text])
