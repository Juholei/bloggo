(ns bloggo.main.routes
  (:require [reitit.frontend :as rf]
            [reitit.frontend.easy :as rfe]
            [reitit.frontend.controllers :as rfc]
            [reagent.core :as r]
            [tuck.core :as t :refer-macros [define-event]]
            [bloggo.main.module-loader :as loader]))

(define-event SetView [view-key]
  {:path [:view]}
  view-key)

(defn routes [e!]
  [["/" {:name ::frontpage
         :controllers [{:start #(e! (->SetView ::frontpage))}]}]
   ["/editor" {:name ::editor
               :controllers [{:start (fn load-and-open-editor! []
                                       (loader/load-module "editor"
                                                           #(e! (->SetView ::editor))))}]}]])
(defonce  match (r/atom nil))

(defn route-matcher [new-match]
  (swap! match (fn [old-match]
                 (if new-match
                   (assoc new-match :controllers (rfc/apply-controllers (:controllers old-match) new-match))))))

(defn init-routes! [e!]
  (rfe/start!
   (rf/router (routes e!))
   route-matcher
   {:use-fragment false}))

(defn href [page]
  (rfe/href page))

