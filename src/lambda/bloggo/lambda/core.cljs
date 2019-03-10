(ns bloggo.lambda.core
  (:require [bloggo.lambda.util :as util]))

(defn posts [e ctx cb]
  (println (-> e util/clojurify-event :path-parameters))
  (cb nil (clj->js {:statusCode 200
                    :body "moi"})))



