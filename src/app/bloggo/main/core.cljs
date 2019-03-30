(ns bloggo.main.core
  (:require [reagent.core :as r]
            [tuck.core :as t]
            [datafrisk.core :as df]
            [bloggo.main.state :as state]
            [bloggo.main.module-loader :as loader]
            [bloggo.main.routes :as routes]
            [bloggo.main.components.navbar :refer [navbar]]
            [bloggo.main.view-resolver :as view-resolver :refer [root-view]]))

(defn navlinks []
  [{:url (routes/href ::routes/frontpage) :label "Frontpage"}
   {:url (routes/href ::routes/editor) :label "Write a new hot take"}])

(defn app [e! app-state]
  (r/with-let [_ (routes/init-routes! e!)
               links (navlinks)]
    [:<>
     [navbar links]
     [root-view app-state e!]
     (when goog.DEBUG
       [df/DataFriskShell app-state])]))

(defn mount-app! []
  (r/render [t/tuck state/app-state app]
            (.getElementById js/document "app")))

(defn init []
  (mount-app!))

(defn refresh! []
  (r/force-update-all))
