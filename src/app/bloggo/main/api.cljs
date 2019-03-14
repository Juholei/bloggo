(ns bloggo.main.api
  (:require [ajax.core :as ajax]
            [tuck.core :as tuck :refer-macros [define-event]]
            [tuck.effect :as fx]))

(goog-define URL "")

(define-event ErrorHandler [error]
  {}
  (println "error" error)
  app)

(defmethod fx/process-effect ::get [e! {:keys [path on-success on-error]
                                        :or {on-error ->ErrorHandler}}]
  (ajax/GET (str URL path)
            {:handler       #(e! (on-success %))
             :error-handler #(e! (on-error %))}))
