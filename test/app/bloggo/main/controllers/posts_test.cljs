(ns bloggo.main.controllers.posts-test
  (:require [bloggo.main.controllers.posts :as sut]
            [cljs.test :refer [deftest testing is]]
            [tuck.core :as tuck]))

(deftest test-add-posts
  (testing "Tuck event AddPosts sets the posts in the correct place in the app-state"
    (is (= (tuck/process-event (sut/->SetPosts [{:title "Test post"}]) {})
           {:posts [{:title "Test post"}]}))))

(deftest test-GetPosts
  (testing "GetPosts set in-progress? to true"
    (is (true? (-> (sut/->GetPosts 0)
                   (tuck/process-event {})
                   .-app
                   :in-progress?))))
  (testing "GetPosts request url uses the given page number"
    (is (= (-> (sut/->GetPosts 2)
               (tuck/process-event {})
               .-effects
               first
               :path)
           "/posts/2"))))

(deftest test-ShowPost
  (testing "ShowPost sets given post to current post and"
    (is (= (-> (sut/->ShowPost {:title "This is a post"})
               (tuck/process-event {})
               :current-post)
           {:title "This is a post"}))))
