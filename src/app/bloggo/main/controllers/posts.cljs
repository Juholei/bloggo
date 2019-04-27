(ns bloggo.main.controllers.posts
  (:require [tuck.core :as tuck :refer-macros [define-event]]
            [bloggo.main.api :as api]))

(define-event SetPosts [posts]
  {:path [:posts]}
  posts)

(define-event GetPosts [page]
  {}
  (tuck/fx (assoc app :in-progress? true)
           {:tuck.effect/type ::api/get
            :path             (str "/posts/" page)
            :on-success       ->SetPosts}))

(define-event ShowPost [post]
  {}
  (assoc app :in-progress? false :current-post post))

(define-event GetPost [id on-success]
  {}
  (tuck/fx (assoc app :in-progress? true)
           {:tuck.effect/type ::api/get
            :path (str "/post/" id)
            :on-success on-success}))

(define-event SetCurrentPage [page-number]
  {:path [:page-number]}
  (int page-number))
