(ns bloggo.lambda.util
  (:require [camel-snake-kebab.core :refer [->kebab-case-keyword]]
            [camel-snake-kebab.extras :refer [transform-keys]]))

(defn clojurify-event
  "Transforms lambda event from JS object to a
  Clojure map with kebab-cased keywords as keys"
  [event]
  (->> event
       js->clj
       (transform-keys ->kebab-case-keyword)))
