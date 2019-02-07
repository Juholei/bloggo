(ns bloggo.frontend.core
  (:require [reagent.core :as r]
            [tuck.core :as t]
            [bloggo.frontend.state :as state]
            [bloggo.frontend.views.root-view :refer [root-view]]))

(defn app-root []
  [:h1 "Hello world!"])

(defn mount-app []
  (r/render [t/tuck state/app-state root-view]
            (.getElementById js/document "app")))

(defn init []
  (mount-app))
