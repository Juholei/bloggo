(ns bloggo.main.api
  (:require [ajax.core :as ajax]
            [tuck.core :as tuck :refer-macros [define-event]]
            [tuck.effect :as fx]
            [camel-snake-kebab.core :as cskc]
            [camel-snake-kebab.extras :as cske]))

(goog-define URL "")

(defn json->map [json]
  (cske/transform-keys cskc/->kebab-case-keyword json))

(define-event ErrorHandler [error]
  {}
  (println "error" error)
  app)

(defmethod fx/process-effect ::get [e! {:keys [path on-success on-error]
                                        :or {on-error ->ErrorHandler}}]
  (ajax/GET (str URL path)
            {:handler       #(e! (on-success (json->map %)))
             :error-handler #(e! (on-error %))}))

(defmethod fx/process-effect ::post [e! {:keys [path params on-success on-error]
                                         :or {on-error ->ErrorHandler}}]
  (ajax/POST (str URL path) {:handler       #(e! (on-success (json->map %)))
                             :format        :json
                             :params        params
                             :error-handler #(e! (on-error %))}))
