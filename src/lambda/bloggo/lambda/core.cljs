(ns bloggo.lambda.core
  (:require [bloggo.lambda.util :as util]))

(defn posts [e ctx cb]
  (println (-> e util/clojurify-event :path-parameters))
  (cb nil (clj->js {:statusCode 200
                    :body (-> [{:post "## Hello \n * jee \n * woah"
                                 :title "This is a blog post"}]
                              clj->js
                              js/JSON.stringify)})))



