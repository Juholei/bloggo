(ns bloggo.editor.controllers.editor
  (:require [tuck.core :as t :refer-macros [define-event]]
            [bloggo.main.api :as api]))

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

(define-event PostPublished [response]
  {}
  (-> app
      (dissoc :new-post)
      (assoc :alert "Post published")))

(define-event PublishPost []
  {}
  (t/fx (assoc app :in-progress? true)
        {:tuck.effect/type ::api/post
         :path             "/new-post"
         :params           (:new-post app)
         :on-success       ->PostPublished}
        #(println "Unleashing your think piece...")))
