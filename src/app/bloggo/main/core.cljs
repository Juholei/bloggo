(ns bloggo.main.core
  (:require [reagent.core :as r]
            [tuck.core :as t]
            [bloggo.main.state :as state]
            [bloggo.main.module-loader :as loader]
            [bloggo.main.routes :as routes]))

(defmulti root-view :view)
(defmethod root-view :default [params]
  (println "default" params))

(defmethod root-view ::routes/frontpage [app-state e!]
  [:<>
   [:h1 "Bloggo Blog Platform - Disrupting blogosphere since 20xx"]
   [:a {:href (routes/href ::routes/frontpage)} "Frontpage"]
   [:a {:href (routes/href ::routes/editor)} "Editor"]])

(defn app [e! app-state]
  (r/with-let [_ (routes/init-routes! e!)]
    [root-view app-state e!]))

(defn mount-app! []
  (r/render [t/tuck state/app-state app]
            (.getElementById js/document "app")))

(defn init []
  (mount-app!))
