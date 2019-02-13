(ns bloggo.main.module-loader
  (:require [shadow.loader :as loader]))

(defn on-error []
  (js/console.log "Cannot load module"))

(defn load-module
  ([module]
   (loader/load module))
  ([module on-load]
   (-> (loader/load module)
       (.then on-load on-error))))

