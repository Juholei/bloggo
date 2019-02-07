(ns bloggo.frontend.app
  (:require [reagent.core :as r]))

(defn app-root []
  [:h1 "Hello world!"])

(defn mount-app []
  (r/render [app-root]
            (.getElementById js/document "app")))

(defn init []
  (mount-app))
