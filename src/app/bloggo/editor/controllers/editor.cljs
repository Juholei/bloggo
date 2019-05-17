(ns bloggo.editor.controllers.editor
  (:require [tuck.core :as t :refer-macros [define-event]]))

(define-event UpdateNewPostContent [post-content]
  {:path [:new-post :content]}
  post-content)

(define-event UpdateNewPostTitle [title]
  {:path [:new-post :title]}
  title)

(define-event SaveCurrentPost []
  {}
  (t/fx (assoc app :in-progress? true)
        #(println "Saving the post...")))

(define-event PublishPost []
  {}
  (t/fx (assoc app :in-progress? true)
        #(println "Unleashing your think piece...")))
