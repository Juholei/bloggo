(ns bloggo.editor.core
  (:require [reagent.core :as r]
            [tuck.core :as t]
            [bloggo.editor.state :as state]
            [bloggo.editor.views.root-view :refer [root-view]]))

(defn mount-app []
  (r/render [t/tuck state/app-state root-view]
            (.getElementById js/document "app")))

(defn init []
  (mount-app))
